//GameType = elenco dei giochi 
package it.unibo.gridgames.model;

/**
 * 
 * * Represents the available grid games in the application.
 */

public enum GameType {

    /**
     * @param name the display name of the game type
     */

    GAME_2048("2048"),
    SUDOKU("Sudoku"),
    PUZZLE_15("Gioco del 15");

    private final String name;

    GameType(String name) {
        this.name = name;
    }

    public String getDisplayName() {
        return this.name;
    }
}
