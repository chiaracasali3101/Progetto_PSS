//GameType = elenco dei giochi 
package it.unibo.gridgames.model;

/**
 * 
 * * Represents the available grid games in the application.
 */

public enum GameType {

    GAME_2048("2048"),
    SUDOKU("Sudoku"),
    PUZZLE_15("Gioco del 15");

    private final String name;

    /**
     * Constructs a GameType enum with a display name.
     * @param name
     */
    GameType(String name) {
        this.name = name;
    }

    /**
     * Returns the display name of the game type.
     * @return
     */
    public String getDisplayName() {
        return this.name;
    }
}
