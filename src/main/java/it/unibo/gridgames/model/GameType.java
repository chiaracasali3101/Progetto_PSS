//GameType = elenco dei giochi 
package it.unibo.gridgames.model;

public enum GameType {
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
