package it.unibo.gridgames.persistence;

import it.unibo.gridgames.model.GameRecord;
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


public class ScoreManagerTest {
    @TempDir
    Path tempDir;
    private ScoreManager scoreManager;
    private Path testFile;

    @BeforeEach
    public void setUp() throws IOException {
        testFile = tempDir.resolve("test_scores.json");
        // esisterà una classe 'CsvScoreManager' che implementa 'ScoreManager'
        testFile = tempDir.resolve("test_scores.csv");
        scoreManager = new FileScoreManager(testFile.toString());
    }   

    @Test
    public void testSaveAndLoadScores() throws IOException {
        LocalDateTime now = LocalDateTime.now().withNano(0);
        GameRecord record1 = new GameRecord("Alice", 100, "TIC_TAC_TOE", 10, now);
        GameRecord record2 = new GameRecord("Bob", 200, "TIC_TAC_TOE", 15, now);
    
        scoreManager.saveScore(record1);
        scoreManager.saveScore(record2);
    
        final List<GameRecord> loadedScores = scoreManager.loadAllScores();
        assertEquals(2, loadedScores.size());
    
        assertEquals(record1.getPlayerName(), loadedScores.get(0).getPlayerName());
        assertEquals(record1.getScore(), loadedScores.get(0).getScore());
        assertEquals(record1.getGameType(), loadedScores.get(0).getGameType());
    
        assertEquals(record2.getPlayerName(), loadedScores.get(1).getPlayerName());
        assertEquals(record2.getScore(), loadedScores.get(1).getScore());
        assertEquals(record2.getGameType(), loadedScores.get(1).getGameType());
    }
}
