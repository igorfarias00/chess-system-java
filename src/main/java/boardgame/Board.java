package boardgame;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private Integer rows;

    private Integer columns;

    private Piece[][] pieces;

    // ==========================================================================


    public Board(Integer rows, Integer columns) {
        if (rows < 1 || columns < 1){
            throw new BoardException("Error creating board: there must be at least 1 row and 1 column!");
        }
        this.rows = rows;
        this.columns = columns;
        this.pieces = new Piece[rows][columns];
    }


    // ==========================================================================

    public Piece piece(Integer row, Integer column){
        if(!positionExists(row, column)){
            throw  new BoardException("Position not on the board!");
        }
        return this.pieces[row][column];
    }

    public Piece piece(Position position){
        if(!positionExists(position)){
            throw  new BoardException("Position not on the board!");
        }
        return this.pieces[position.getRow()][position.getColumn()];
    }

    public void placePiece(Piece piece, Position position){
        if(thereIsAPiece(position)){
            throw new BoardException("There is already a piece on position " + position);
        }
        pieces[position.getRow()][position.getColumn()] = piece;
        piece.position = position;
    }

    public Piece removePiece(Position position){

        return null;
    }

    public boolean positionExists(Position position){
        return positionExists(position.getRow(), position.getColumn());
    }

    private boolean positionExists(Integer row, Integer column){
        return row >= 0 && row < rows && column >= 0 && column < columns;
    }

    public boolean thereIsAPiece(Position position){
        if(!positionExists(position)){
            throw new BoardException("Position not on the board!");
        }
        return piece(position) != null;
    }

    //++++++++++++++++++++++++++++++++++++++-------------------------------------

    public Integer getRows() {
        return rows;
    }

    private void setRows(Integer rows) {
        this.rows = rows;
    }

    public Integer getColumns() {
        return columns;
    }

    private void setColumns(Integer columns) {
        this.columns = columns;
    }
}
