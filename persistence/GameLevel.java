//enum per i livelli

package persistence;

//livello
public enum GameLevel{
    EASY(3),
    MEDIUM(4),
    HARD(5);

    private final int gridSize;

    GameLevel (int gridSize){
        this.gridSize = gridSize;
    }

    public int getGridSize(){
        return gridSize;
    }
}
