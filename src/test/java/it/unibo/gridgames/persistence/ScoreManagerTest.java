package it.unibo.gridgames.persistence;

import it.unibo.gridgames.model.GameRecordImpl;
import it.unibo.gridgames.model.GameType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Unit tests for the ScoreManager class.
 * ScoreManagerTest
 */
public class ScoreManagerTest {

    @TempDir
    private Path tempDir;

    private ScoreManager scoreManager;

    /**
     * Setup method to initialize the ScoreManager instance before each test.
     */
    @BeforeEach
    public void setUp() {
        final Path tempFile = tempDir.resolve("scores_test.csv");
        this.scoreManager = new ScoreManagerImpl(tempFile.toString());
    }

    /**
     * Test for the loadAllScores method of ScoreManager when the file does not exist.
     * 
     * @throws IOException
     */
    @Test
    public void testLoadScoresWhenFileDoesNotExist() throws IOException {
        final List<GameRecordImpl> scores = this.scoreManager.loadAllScores();
        assertTrue(scores.isEmpty(), "La lista deve essere vuota se il file non esiste");
    }

    /**
     * Test for the getNumberOfGamesPlayed method of ScoreManager.
     * 
     * @throws IOException
     */
    @Test
    public void testGetNumberOfGamesPlayed() throws IOException {
        final LocalDateTime now = LocalDateTime.now().withNano(0);
        final GameRecordImpl record1 = new GameRecordImpl("Alice", 100, GameType.GAME_2048, 10, 60L, now);
        final GameRecordImpl record2 = new GameRecordImpl("Bob", 200, GameType.SUDOKU, 20, 120L, now);
        final GameRecordImpl record3 = new GameRecordImpl("Charlie", 300, GameType.PUZZLE_15, 0, 180L, now);

        this.scoreManager.saveScore(record1);
        this.scoreManager.saveScore(record2);
        this.scoreManager.saveScore(record3);

        System.out.println("NOME ENUM: " + GameType.PUZZLE_15.name());
        System.out.println("RECORD LETTI: " + this.scoreManager.loadAllScores());

        assertEquals(1, this.scoreManager.getNumberOfGamesPlayed(GameType.GAME_2048));
        assertEquals(1, this.scoreManager.getNumberOfGamesPlayed(GameType.SUDOKU));
        assertEquals(1, this.scoreManager.getNumberOfGamesPlayed(GameType.PUZZLE_15));
    }

    /**
     * Test for the getTopScores method of ScoreManager.
     * 
     * @throws IOException
     */
    @Test
    public void getTopScore() throws IOException {
        final LocalDateTime now = LocalDateTime.now().withNano(0);
        final GameRecordImpl record1 = new GameRecordImpl("Alice", 100, GameType.GAME_2048, 10, 60L, now);
        final GameRecordImpl record2 = new GameRecordImpl("Bob", 200, GameType.GAME_2048, 20, 120L, now);
        final GameRecordImpl record3 = new GameRecordImpl("Charlie", 300, GameType.GAME_2048, 30, 180L, now);

        this.scoreManager.saveScore(record1);
        this.scoreManager.saveScore(record2);
        this.scoreManager.saveScore(record3);

        final List<GameRecordImpl> topScores = this.scoreManager.getTopScores(GameType.GAME_2048, 1);
        assertEquals(1, topScores.size(), "Dovrebbe esserci un solo record nella classifica");
        assertEquals(300, topScores.get(0).getScore(), "Il punteggio più alto dovrebbe essere 300");
    }

    /**
     * Test for the getHighestScore method of ScoreManager.
     * 
     * @throws IOException
     */
    @Test
    public void testGetHighestScore() throws IOException {
        final LocalDateTime now = LocalDateTime.now().withNano(0);
        this.scoreManager.saveScore(new GameRecordImpl("Alice", 100, GameType.GAME_2048, 10, 60L, now));
        this.scoreManager.saveScore(new GameRecordImpl("Bob", 300, GameType.GAME_2048, 20, 120L, now));

        final GameRecordImpl highest = this.scoreManager.getHighestScore(GameType.GAME_2048);
        assertEquals(300, highest.getScore());
        assertEquals("Bob", highest.getPlayerName());
    }
}
