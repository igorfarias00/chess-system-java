package boardgame;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private Integer rows;

    private Integer columns;

    private Piece[][] pieces;

    // ==========================================================================


    public Board(Integer rows, Integer columns) {
        this.rows = rows;
        this.columns = columns;
        this.pieces = new Piece[rows][columns];
    }


    // ==========================================================================

    public Piece piece(Integer row, Integer columns){

        return this.pieces[row][columns];
    }

    public Piece piece(Position position){
        return this.pieces[position.getRow()][position.getColumn()];
    }

    public void placePiece(Piece piece, Position position){
        pieces[position.getRow()][position.getColumn()] = piece;
        piece.position = position;
    }

    public Piece removePiece(Position position){

        return null;
    }

    public boolean positionExists(Position position){



        return false;
    }

    public boolean thereIsAPiece(Position position){

        return false;
    }

    //++++++++++++++++++++++++++++++++++++++-------------------------------------

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public Integer getColumns() {
        return columns;
    }

    public void setColumns(Integer columns) {
        this.columns = columns;
    }
}
