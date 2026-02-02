package persistence;
import java.util.List; 

public interface ScoreManager {
    //aggiunta di un nuovo record
    void saveScore(String playerName, int score);

    //classifica dei primi X punteggi
    List <GameScore> getTopScores(int limit);

    //punteggio medio di tutti i giocatori
    double getAverageScore();
}