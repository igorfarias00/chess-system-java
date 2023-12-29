package chess;

import boardgame.Position;

public class ChessPosition {
    private char column;

    private Integer row;

    // ========================================================================

    public ChessPosition(char column, Integer row) {
        this.column = column;
        this.row = row;
    }


    // ========================================================================

    protected Position toPosition(){

        return null;
    }

    protected ChessPosition fromPosition(Position position){

        return null;
    }


    // ++++++++++++++++++++++++++++++++++-------------------------------------
    public char getColumn() {
        return column;
    }

    public void setColumn(char column) {
        this.column = column;
    }

    public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }
}
