package persistence;

import java.util.List; 

/**
 * interfaccia con i metodi per gestire i punteggi degli utenti
 */

public interface ScoreManager {
    /**
     * aggiunta di un nuovo record
     * @param score il punteggio da aggiungere alla lista dei punteggi
     */
    void addScore(GameScore score);

    /** 
     * classifica dei primi 10 punteggi
     * @return una lista dei primi 10 punteggi ordinati in ordine crescente
     */
    List <GameScore> getTopScores();

    /**
     * punteggio medio di tutti i giocatori
     * @return il punteggio medio di tutti i giocatori
     */ 
    double getAverageScore();
}