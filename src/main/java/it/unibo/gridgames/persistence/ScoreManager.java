package it.unibo.gridgames.persistence;

import it.unibo.gridgames.model.GameRecord;
import it.unibo.gridgames.model.GameType;

import java.io.IOException;
import java.util.List;

//interfaccia per la gestione dei punteggi dei giochi
public interface ScoreManager {
    //salva il punteggio di una partita appena finita nel file di persistenza
    void saveScore(GameRecord record) throws IOException;

    //riapre il file e converte tutti i record in oggetti GameRecord restituendo la lista
    List<GameRecord> loadAllScores() throws IOException;

    //estrae la classifica filtrando il gioco e limitando il numero di record visualizzati
    List<GameRecord> getTopScores(GameType gameType, int limit);
}
