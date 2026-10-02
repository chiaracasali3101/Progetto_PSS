package it.unibo.gridgames.sudoku.model;

public class Position {
    private final int row;
    private final int column;
    private static final int GRID_SIZE = 9;

    public Position (final int row, final int column ){
        
        if(row < 0 || row >= GRID_SIZE || column < 0 || column >= GRID_SIZE){
            throw new IllegalArgumentException("Position out of grid");
        }

        this.row = row;
        this.column = column;
    }

    public int getRow(){
        return this.row;
    }

    public int getColumn(){
        return this.column;
    }
}
