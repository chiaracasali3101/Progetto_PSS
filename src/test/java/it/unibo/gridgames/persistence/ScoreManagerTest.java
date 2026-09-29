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

    private ScoreManager scoreManager;

    @BeforeEach
    public void setUp(@TempDir final Path tempDir) {
        final Path tempFile = tempDir.resolve("scores_test.csv");
        this.scoreManager = new FileScoreManager(tempFile.toString());
    }

    @Test
    public void testLoadScoresWhenFileDoesNotExist() throws IOException {
        final List<GameRecord> scores = this.scoreManager.loadAllScores();
        assertTrue(scores.isEmpty(), "La lista deve essere vuota se il file non esiste");
    }

    @Test
    public void testGetNumberOfGamesPlayed() throws IOException {
        final LocalDateTime now = LocalDateTime.now().withNano(0);
        final GameRecord record1 = new GameRecord("Alice", 100, GameType.GAME_2048, 10, 60L, now);
        final GameRecord record2 = new GameRecord("Bob", 200, GameType.SUDOKU, 20, 120L, now);
        final GameRecord record3 = new GameRecord("Charlie", 300, GameType.PUZZLE_15, 0, 180L, now);

        this.scoreManager.saveScore(record1);
        this.scoreManager.saveScore(record2);

        //assertEquals(2, this.scoreManager.getNumberOfGamesPlayed(null), "Il numero totale di giochi giocati dovrebbe essere 2");
    }
}