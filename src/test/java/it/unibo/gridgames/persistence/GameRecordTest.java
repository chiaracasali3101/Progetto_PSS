import it.unibo.gridgames.model.GameRecord;
import it.unibo.gridgames.model.GameType;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GameRecordTest {

    @Test
    public void testValidGameRecordCreation() {
        final LocalDateTime now = LocalDateTime.now();
        final GameRecord record = new GameRecord("Alice", 100, GameType.SUDOKU, 10, 60L, now);

        assertEquals("Alice", record.getPlayerName());
        assertEquals(100, record.getScore());
        assertEquals(GameType.SUDOKU, record.getGameType());
        assertEquals(10, record.getMoves());
        assertEquals(60L, record.getDurationSeconds());
        assertEquals(now, record.getTimestamp());
    }

    @Test
    public void testInvalidPlayerNameThrowsException() {
        final LocalDateTime now = LocalDateTime.now();

        assertThrows(IllegalArgumentException.class, () ->
            new GameRecord(null, 100, GameType.SUDOKU, 10, 60L, now)
        );

        assertThrows(IllegalArgumentException.class, () ->
            new GameRecord("", 100, GameType.SUDOKU, 10, 60L, now)
        );

        assertThrows(IllegalArgumentException.class, () ->
            new GameRecord("   ", 100, GameType.SUDOKU, 10, 60L, now)
        );

        assertThrows(IllegalArgumentException.class, () ->
            new GameRecord("Alice,Bob", 100, GameType.SUDOKU, 10, 60L, now)
        );
    }

    @Test
    public void testNegativeMetricsThrowException() {
        final LocalDateTime now = LocalDateTime.now();

        assertThrows(IllegalArgumentException.class, () ->
            new GameRecord("Alice", -5, GameType.SUDOKU, 10, 60L, now)
        );

        assertThrows(IllegalArgumentException.class, () ->
            new GameRecord("Alice", 100, GameType.SUDOKU, -1, 60L, now)
        );

        assertThrows(IllegalArgumentException.class, () ->
            new GameRecord("Alice", 100, GameType.SUDOKU, 10, -5L, now)
        );
    }
}