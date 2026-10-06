package it.unibo.gridgames.model;
//interfaccia 

import java.time.LocalDateTime;

public interface GameRecord {
    /**
     * Returns the name of the player associated with this game record.
     * 
     * @return player's name
     */
    public String getPlayerName();

    /**
     * Returns the score achieved by the player in this game record.
     * 
     * @return score achieved by the player
     */
    public int getScore();

    /**
     * Returns the type of game associated with this game record.
     * 
     * @return game type (e.g., 2048, Sudoku, 15Game)
     */
    public GameType getGameType();

    /**
     * Returns the number of moves made by the player in this game record.
     * 
     * @return number of moves made by the player
     */
    public int getMoves();

    /**
     * Returns the duration of the game in seconds for this game record.
     * 
     * @return duration of the game in seconds
     */
    public long getDurationSeconds();

    /**
     * Returns the timestamp indicating when this game record was created or
     * recorded.
     * 
     * @return timestamp of the game record
     */
    public LocalDateTime getTimestamp();
}
