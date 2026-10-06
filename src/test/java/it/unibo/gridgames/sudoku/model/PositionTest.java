package it.unibo.gridgames.sudoku.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class PositionTest {

    @Test
    void validPositionKeepsRowAndColumn() {
        Position position = new Position(2, 5);

        assertEquals(2, position.getRow());
        assertEquals(5, position.getColumn());
    }

    @Test
    void negativeRowIsRejected() {
        assertThrows(IllegalArgumentException.class, () -> new Position(-1, 0));
    }

    @Test
    void negativeColumnIsRejected() {
        assertThrows(IllegalArgumentException.class, () -> new Position(0, -1));
    }

        @Test
    void rowTooLargeIsRejected() {
        assertThrows(IllegalArgumentException.class, () -> new Position(9, 0));
    }

    @Test
    void columnTooLargeIsRejected() {
        assertThrows(IllegalArgumentException.class, () -> new Position(0, 9));
    }
}