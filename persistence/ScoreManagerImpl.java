//classe che implementa l'interfaccia ScoreManager per gestire i punteggi degli utenti

package persistence;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ScoreManagerImpl implements ScoreManager {
    //variabile temporanea per salvare i punteggi
    private final List <GameScore> scores = new ArrayList<>();

    @Override //aggiunta di un nuovo record
    public void addScore(GameScore score) {
        scores.add(score); //aggiunge il record alla lista
    }

    @Override //classifica dei primi X punteggi
    public List <GameScore> getTopScores() {
        return scores.stream()
                .sorted(Comparator.comparingInt(GameScore::getScore))
                .limit(10) //limita i primi 10 punteggi
                .toList(); //restituisce la lista dei punteggi
    }

    @Override //punteggio medio di tutti i giocatori
    public double getAverageScore() {
        return scores.stream()
                .mapToInt(GameScore::getScore)
                .average()
                .orElse(0.0);
    }
}