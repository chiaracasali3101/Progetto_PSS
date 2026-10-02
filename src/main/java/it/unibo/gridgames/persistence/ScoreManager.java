package it.unibo.gridgames.persistence;

import it.unibo.gridgames.model.GameRecord;
import it.unibo.gridgames.model.GameType;

import java.io.IOException;
import java.util.List;

/**
 * 
 * Interface defining the persistence operations and statistical queries for managing game score records.
 */

//interfaccia per la gestione dei punteggi dei giochi
public interface ScoreManager {

    /**
     * Saves a new game score record.
     * @param record the game record to save
     * @throws IOException if an error occurs while writing to storage
     * @throws NullPointerException if record is null
     */

    //salva il punteggio di una partita appena finita nel file di persistenza
    void saveScore(GameRecord record) throws IOException;

    /**
     * Loads all game score records from storage.
     * @return
     * @throws IOException
     */
    //riapre il file e converte tutti i record in oggetti GameRecord restituendo la lista
    List<GameRecord> loadAllScores() throws IOException;

    /**
     * Retrieves the top scores for a specific game type, limited to a specified number of records.
     * @param gameType
     * @param limit
     * @return
     */
    //estrae la classifica filtrando il gioco e limitando il numero di record visualizzati
    List<GameRecord> getTopScores(GameType gameType, int limit);


    /**
     * Retrieves the number of games played for a specific game type.
     * @param gameType
     * @return
     */
    //estrae il numero delle partite giocate di un gioco
    int getNumberOfGamesPlayed(GameType gameType);
    
    /**
     *  Retrieves the average score for a specific game type.
     * @param gameType
     * @return
     */
    //restituisce la media dei punteggi di un gioco specifico
    double getAverageScore(GameType gameType);

    /**
     * Retrieves the highest score for a specific game type.
     * @param gameType
     * @return
     */
    //mostra il punteggio più alto di un gioco specifico
    GameRecord getHighestScore(GameType gameType);
}
