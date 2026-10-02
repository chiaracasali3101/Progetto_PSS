package it.unibo.gridgames.sudoku.model;

public class Position {
    private final int row;
    private final int column;

    public Position (final int row, final int column ){
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
