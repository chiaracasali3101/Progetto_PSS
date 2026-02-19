package persistence;
import java.time.LocalDateTime; 
import java.util.Objects;

/**
 * classe che rappresenta un record di punteggio di un giocatore, con il nome del giocatore, il punteggio ottenuto, la data e l'ora in cui è stato ottenuto e il livello di gioco
 */
public class GameScore {
    private final String playerName;
    private final int score;
    private final LocalDateTime dateTime;
    private final GameLevel level;

    /**
     * costruttore che inizializza i campi
     * @param playerName il nome del giocatore
     * @param score il punteggio ottenuto
     * @param dateTime la data e l'ora in cui è stato ottenuto il
     * @param level il livello di gioco
     * @throws IllegalArgumentException se playerName è null o vuoto
     */
    public GameScore(String playerName, int score, LocalDateTime dateTime, GameLevel level) {
        if (playerName == null || playerName.isEmpty()) {
            throw new IllegalArgumentException("Il nome del giocatore non può essere null");
        }
        this.playerName = playerName;
        this.score = score;
        this.dateTime = dateTime;
        this.level = level;
    }

    /** @return il nome del giocatore */
    public String getPlayerName() {
        return playerName;
    }

    /** @return il punteggio ottenuto */
    public int getScore() {
        return score;
    }

    /** @return la data e l'ora in cui è stato ottenuto il punteggio */
    public LocalDateTime getDateTime(){
        return dateTime;
    }

    /** @return il livello di gioco */
    public GameLevel getLevel(){
        return level;
    }

    
    /**
    *confronta due oggetti GameScore per verificare se sono uguali, basandosi sui campi playerName, score e dateTime
    @param o l'oggetto da confrontare
    @return true se i due oggetti sono uguali, false altrimenti
    */
    @Override
    public boolean equals (Object o) {
        if (this == o ) {
            return true;
        }
        if (!(o instanceof GameScore)) {
            return false;
        }
        GameScore gameScore = (GameScore) o;
        return score == gameScore.score &&
        Objects.equals (playerName, gameScore.playerName) &&
        Objects.equals (dateTime, gameScore.dateTime);
    }

    /** @return l'hash code dell'oggetto */
    @Override
    public int hashCode() {
        return Objects.hash(playerName, score, dateTime);
    }

    /** @return numero di mosse effettuate */
    public int getMoves(){
        return moves;
    }

    /** @return rappresentazione del punteggio in testo */
    @Override
    public String toString(){
        return "GameScore{" +
        "playerName='" + playerName + '\'' +
        ", score=" + score +
        ", dateTime=" + dateTime +
        '}';

    }
}
