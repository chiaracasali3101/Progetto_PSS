package main.java.it.unibo.gridgames.model;

public class GameRecord {
    private final String playerName;
    private final int score;
    private final String gameType;
    private final int moves;
    private final long durationSeconds;
    private final java.time.LocalDateTime timestamp;

    public GameRecord (String playerName, int score, String gameType, int moves, java.time.LocalDateTime timestamp){
        this.playerName= playerName;
        this.score= score;
        this.gameType= gameType;
        this.moves = moves;
        this.durationSeconds = 0;
        this.timestamp = timestamp;
    }
}
