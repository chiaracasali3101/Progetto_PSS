package persistence;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.time.LocalDateTime;

/** 
 * classe che implementa l'interfaccia ScoreManager per gestire i punteggi  
 */
public class ScoreManagerImpl implements ScoreManager {

    /** variabile temporanea per salvare i punteggi */
    private final List <GameScore> scores = new ArrayList<>();

    /** 
     * aggiunta di un nuovo record 
     * @param score il punteggio da aggiungere alla lista dei punteggi
     */
    @Override 
    public void addScore(GameScore score) {
        scores.add(score); //aggiunge il record alla lista 
    }

    /** 
     * classifica dei primi X punteggi 
     * @return una lista dei primi 10 punteggi ordinati in ordine crescente
     */
    @Override 
    public List <GameScore> getTopScores() {
        return scores.stream()
                .sorted(Comparator.comparingInt(GameScore::getScore).reversed()
                        .thenComparing(GameScore::getDateTime)) // ordina per punteggio e poi per data
                .limit(10) // limita i primi 10 punteggi **/
                .toList(); // restituisce la lista dei punteggi
    }

    /**
     * Salvataggio dei record in un file formato CSV
     * @param filePath il percorso del file dove salvare i punteggi
     * @throws IOException se si verifica un errore di scrittura
     */
    public void saveToFile(final String filePath) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (GameScore score : scores) {
                writer.write(String.format("%s,%d,%s,%s%n",
                    score.getPlayerName(), score.getScore(), score.getMoves(), score.getDateTime().toString(), score.getLevel().name()));
            }   
        }
    }

    /**
     * Carica i record dal file e li aggiunge alla lista
     * @param filePath il percorso del file da cui caricare i punteggi
     * @throws IOException se si verifica un errore di lettura
     */
    public void loadFromFile(final String filePath) throws IOException {
        try (bufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    GameScore score = new GameScore(
                        parts[0], //nome
                        Integer.pareInt(parts[1]), //punteggio
                        Integer.pareInt(parts[2]), //mosse
                        LocalDateTime.parse(parts[3]), //data e ora
                        GameLevel.valueOf(parts[4]) //livello
                    );
                    scores.add(score); //aggiunge il record alla lista
                }
            }
        }
    }

     /** 
      * punteggio medio di tutti i giocatori 
      */
    @Override
    public double getAverageScore() {
        return scores.stream()
                .mapToInt(GameScore::getScore)
                .average()
                .orElse(0.0);
    }
}
