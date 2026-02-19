package persistence;

/**
 * enum che rappresenta i livelli di gioco, con la dimensione della griglia associata a ciascun livello
 */
public enum GameLevel{
    /** Livello facile con gruglia di dimensione 3. */
    EASY(3),
        /** Livello medio con gruglia di dimensione 4. */
    MEDIUM(4),
        /** Livello difficile con gruglia di dimensione 5. */
    HARD(5);

    private final int gridSize;

    /**
     * costruttore che inizializza la dimensione della griglia associata a ciascun livello
     * @param gridSize
     */
    GameLevel (int gridSize){
        this.gridSize = gridSize;
    }

    /**
     * restituisce la dimensione della griglia associata al livello di gioco
     * @return la dimensione della griglia associata al livello di gioco
     */
    public int getGridSize(){
        return gridSize;
    }
}
