package it.unibo.gridgames.model;
import java.time.LocalDateTime;
import java.util.Objects;

public class GameRecord {
    private final String playerName;
    private final int score;
    private final String gameType;
    private final int moves;
    private long durationSeconds = 0;
    private final java.time.LocalDateTime timestamp;

    //costruttore per il record di gioco
    public GameRecord (String playerName, int score, String gameType, int moves, java.time.LocalDateTime timestamp){
        if (playerName == null || playerName.isBlank()) {
            throw new IllegalArgumentException("Player name cannot be null or blank");
        }
        if (score < 0 || moves < 0 || durationSeconds < 0) {
            throw new IllegalArgumentException("Metrics cannot be negative");
        }
        
        this.playerName= playerName;
        this.score= score;
        this.gameType= gameType;
        this.moves = moves;
        this.durationSeconds = 0;
        this.timestamp = timestamp;
    }

    // metodi getter pubblici per accedere ai campi privati della classe
    //nome giocatore
    public String getPlayerName() { 
        return this.playerName; 
    }

    //gioco
    public String getGameType() { 
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
