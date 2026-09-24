package it.unibo.gridgames.model;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import it.unibo.gridgames.model.GameRecord;

public class GameRecordTest {
    
    //verifica che il costruttore crei correttamente un oggetto con valori validi
    @Test
    public void testGameRecordCreation() {
        LocalDateTime now = LocalDateTime.now();
        GameRecord record = new GameRecord("Alice", 100, "SUDOKU", 10, now);

        assertEquals("Alice", record.getPlayerName());
        assertEquals(100, record.getScore());
        assertEquals("SUDOKU", record.getGameType());
        assertEquals(10, record.getMoves());
        assertEquals(0, record.getDurationSeconds());
        assertEquals(now, record.getTimestamp());
    }

    //verifica che il costruttore lanci un'eccezione se il nome è nullo
    @Test
    public void testInvalidPlayerNameThrowsException() {
        LocalDateTime now = LocalDateTime.now();
        assertThrows(IllegalArgumentException.class, () -> {
            new GameRecord(null, 100, "SUDOKU", 10, now);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new GameRecord("", 100, "SUDOKU", 10, now);
        });
    }

    //verifica che il costruttore lanci un'eccezione se il punteggio o le mosse sono negativi
    @Test
    public void testNegativeMetricsThrowException() {
        final LocalDateTime now = LocalDateTime.now();

        assertThrows(IllegalArgumentException.class, () -> 
            new GameRecord("Alice", -5, "SUDOKU", 10, now)
        );

        assertThrows(IllegalArgumentException.class, () -> 
            new GameRecord("Alice", 100, "SUDOKU", -1, now)
        );
    }
}
