package it.unibo.gridgames.model;
import java.time.LocalDateTime;
import java.util.Objects;

public class GameRecord {
    private final String playerName;
    private final int score;
    private final GameType gameType;
    private final int moves;
    private final long durationSeconds;
    private final java.time.LocalDateTime timestamp;

    //costruttore per il record di gioco
    public GameRecord( final String playerName, final int score, final GameType gameType, final int moves, final long durationSeconds, final LocalDateTime timestamp) {
        if (playerName == null || playerName.isBlank()) {
            throw new IllegalArgumentException("Player name cannot be null or blank");
        }
        if (playerName.contains(",")) {
            throw new IllegalArgumentException("Player name cannot contain commas");
        }
        if (score < 0 || moves < 0 || durationSeconds < 0) {
            throw new IllegalArgumentException("Metrics cannot be negative");
        }
        
        this.playerName= playerName;
        this.score= score;
        this.gameType = Objects.requireNonNull(gameType, "GameType cannot be null");
        this.timestamp = Objects.requireNonNull(timestamp, "Timestamp cannot be null");
        this.moves = moves;
        this.durationSeconds = durationSeconds;
    }

    // metodi getter pubblici per accedere ai campi privati della classe
    //nome giocatore
    public String getPlayerName() { 
        return this.playerName; 
    }

    //gioco
    public GameType getGameType() { 
        return this.gameType; 
    }

    //punteggio
    public int getScore() { 
        return this.score; 
    }

    //mosse
    public int getMoves() { 
        return this.moves; 
    }

    //tempo
    public long getDurationSeconds() { 
        return this.durationSeconds; 
    }

    //quando è stata giocata la partita
    public LocalDateTime getTimestamp() { 
        return this.timestamp; 
    }
}
