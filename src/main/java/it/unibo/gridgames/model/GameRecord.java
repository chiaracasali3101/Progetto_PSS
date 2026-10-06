package it.unibo.gridgames.model;
//interfaccia 

import java.time.LocalDateTime;

public interface GameRecord {
    /**
     * Returns the name of the player associated with this game record.
     * @return
     */
    public String getPlayerName();

    /**
     * Returns the score achieved by the player in this game record.
     * @return
     */
    public int getScore();

    /**
     * Returns the type of game associated with this game record.
     * @return
     */
    public GameType getGameType();

    /**
     * Returns the number of moves made by the player in this game record.
     * @return
     */
    public int getMoves();

    /**
     * Returns the duration of the game in seconds for this game record.
     * @return
     */
    public long getDurationSeconds();

    /**
     * Returns the timestamp indicating when this game record was created or recorded.
     * @return
     */
    public LocalDateTime getTimestamp();
}
