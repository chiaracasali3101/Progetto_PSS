//interfaccia con i metodi per gestire i punteggi degli utenti

package persistence;
import java.util.List; 

public interface ScoreManager {
    //aggiunta di un nuovo record
    void addScore(GameScore score);

    //classifica dei primi 10 punteggi
    List <GameScore> getTopScores();

    //punteggio medio di tutti i giocatori
    double getAverageScore();
}