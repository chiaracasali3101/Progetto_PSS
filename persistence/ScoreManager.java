package persistence;

import java.util.List; 
import java.io.IOException;

/**
 * interfaccia con i metodi per gestire i punteggi degli utenti
 */

public interface ScoreManager {
    /**
     * aggiunta di un nuovo record
     * @param score il punteggio da aggiungere alla lista dei punteggi
     */
    void addScore(GameScore score);

    /** 
     * classifica dei primi 10 punteggi
     * @return una lista dei primi 10 punteggi ordinati in ordine decrescente
     */
    List <GameScore> getTopScores();

    /**
     * punteggio medio di tutti i giocatori
     * @return il punteggio medio di tutti i giocatori
     */ 
    double getAverageScore();

    /**Salva i punteggi correnti su un file permanente
     * @param filePath il percorso del file dove salvare i punteggi
     * @throws IOException se si verifica un errore di scrittura
     */
    void saveToFile(String filePath) throws IOException;

    /**
     * Carica i punteggi salvati nel file 
     * @param filePath il percorso del file 
     * @throws IOException se si verifica un errore di lettura
     */
    void loadFromFile(String filePath) throws IOException;
}