package persistence;
import java.time.LocalDateTime; //gestione data e ora
import java.util.Objects;

//classe punteggio
public class GameScore {
    private final String playerName;
    private final int score;
    private final LocalDateTime dateTime;
    private final GameLevel level;

    //costruttore che inizializza i campi
    public GameScore(String playerName, int score, LocalDateTime dateTime, GameLevel level) {
        this.playerName = playerName;
        this.score = score;
        this.dateTime = dateTime;
        this.level = level;
    }

    //metodi per accedere ai campi della classe
    public String getPlayerName() {
        return playerName;
    }

    public int getScore() {
        return score;
    }

    public LocalDateTime getDateTime(){
        return dateTime;
    }

    public GameLevel getLevel(){
        return level;
    }

    

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

    @Override
    public int hashCode() {
        return Objects.hash(playerName, score, dateTime);
    }

    @Override
    public String toString(){
        return "GameScore{" +
        "playerName='" + playerName + '\'' +
        ", score=" + score +
        ", dateTime=" + dateTime +
        '}';

    }
}
