package main.java.it.unibo.gridgames.persistence;

import it.unibo.gridgames.model.GameRecord;
import it.unibo.gridgames.model.GameType;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.beans.Transient;
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
        scoreManager = new ScoreManager(testFile.toString());
    }   

    @Test
    public void testSaveAndLoadScores() throws IOException {
        GameRecord record1 = new GameRecord("Alice", 100, LocalDateTime.now(), GameType.TIC_TAC_TOE);
        GameRecord record2 = new GameRecord("Bob", 200, LocalDateTime.now(), GameType.TIC_TAC_TOE);
    }   
}
