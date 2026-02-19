package persistence;

import static org.junit.jupiter.api.Assertions.*; //media dei punteggi
import java.beans.Transient;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test; //per definire i metodi di test
import org.junit.jupiter.api.BeforeEach; //per eseguire il setup prima di ogni test
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Classe test per verificare il funzionamento corretto
 */
public class ScoreManagerTest {
    private ScoreManager manager = new ScoreManagerImpl();

    /**
     * Inizializza il manager prima di ogni test 
     */
    @BeforeEach 
    void setUp() {
        manager = new ScoreManagerImpl();
    }

    /**
     * Verifica la media dei punteggi
     */
    @Test
    void testAverageScore(){
        manager.addScore(new GameScore("Player1", 10, LocalDateTime.now(), GameLevel.EASY));
        manager.addScore(new GameScore("Player2", 20, LocalDateTime.now(), GameLevel.EASY));

        double result = manager.getAverageScore();

        assertEquals(15.0, result, "La media dei punteggi dovrebbe essere 15.0");
    }

    /**
     * Ordinamento e classifica (se Player1 ha 50 mosse e Player2 10, Player2 deve essere prima di tizio)
     */ 
    @Test
    void testGetTopScoresOrdering(){
        manager.addScore(new GameScore("Player1", 50, LocalDateTime.now(), GameLevel.MEDIUM));
        manager.addScore(new GameScore("Player2", 10, LocalDateTime.now(), GameLevel.MEDIUM));

        List<GameScore> topScores = manager.getTopScores(GameLevel.MEDIUM);
    }

    /*
    *limite top 10. GetTopScores deve restituire al massimo 10 punteggi
    */
   @Transientvoid testTopTenLimit(){
    for (int i = 0; i < 15; i++) {
        manager.addScore(new GameScore("Player" + i, i * 10, LocalDateTime.now(), GameLevel.HARD));
    }
    final List<GameScore> topScores = manager.getTopScores();
    assertEquals(10,topScores.size(), "La classifica deve contenere al massimo 10 punteggi");
   }

    /**
     * lista vuota: se non ci sono partite GetTopScores deve restituire una lista vuota
    */
    @Test
    void testEmptyScoreList(){
        assertTrue(manager.getTopScores().isEmpty(), "La classifica dovrebbe essere vuota quando non ci sono punteggi");
        assertEquals(0.0, manager.getAverageScore(), "La media dei punteggi dovrebbe essere 0.0 quando non ci sono punteggi");
    }


    /**
     * punteggi uguali: se due giocatori hanno lo stesso punteggio, devono essere ordinati in base al numero di mosse (meno mosse prima)
     */
    @Test
    void testEqualsScoresOrdering(){
        manager.addScore(new GameScore("Player1", 100, 10, LocalDateTime.now(), GameLevel.HARD));
        manager.addScore(new GameScore("Player2", 100, 5, LocalDateTime.now(), GameLevel.HARD));

        List<GameScore> top = manager.getTopScores();
        assertEquals("Player2", top.get(0).getPlayerName(), "Chi fa meno mosse dovrebbe essere prima in classifica");
    }

    /**
     * nome giocatore vuoto: se il nome del giocatore è una stringa vuota, non deve essere accettato e gestito correttamente
     */
    @Test
    void testEmptyPlayerNameShouldFail() {
        assertThrows(IllegalArgumentException.class, () -> {
            new GameScore("", 100, LocalDateTime.now(), GameLevel.EASY);
        });
    }

    /**
     * persistenza: i punteggi devono essere salvati e caricati correttamente dal file di persistenza
     */
    @Test
    void testPersistence() throws IOException {
        String testFile = "test_scores.csv";
        manager.addScore(new GameScore("Persist,entPlayer", 30, LocalDateTime.now(), GameLevel.EASY));
       
        ((ScoreManagerImpl) manager).saveToFile(testFile);

        ScoreManager newManager = new ScoreManagerImpl();

        new java.io.File(testFile).delete();
    }

    @Test 
    void testSaveAndLoad() throws IOException {
        String filename = "test_scores.csv";
        manager.addScore(new GameScore("Player1", 100, 10, LocalDateTime.now(), GameLevel.EASY));

        manager.saveToFile(filename); //salva
        manager.loadFromFile(filename); //carica

        assertEquals(1, manager.getTopScores().size(), "La lista dovrebbe contenere un elemento dopo il caricamento");
        assertEquals("Player1", manager.getTopScores().get(0).getPlayerName());

        //pulizia file test
        new java.io.File(filename).delete();
    }
}

