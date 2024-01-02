package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece {
    public Pawn(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString(){
        return "P";
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
        Position p = new Position(0, 0);


        // ========================================================================
        p.setValues(position.getRow() - 1, position.getColumn());

        // testa se existem movimentos possiveis para cima
        // ci,a
        while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){
            // marca como movimento possivel
            mat[p.getRow()][p.getColumn()] = true;
            p.setRow(p.getRow() - 1);

        }
        // teste se a ultima possição para cima é uma peça inimiga
        if(getBoard().positionExists(p) && isThereOpponentPiece(p)){
            // marca como movimento possivel
            mat[p.getRow()][p.getColumn()] = true;
        }


        return mat;
    }
}
