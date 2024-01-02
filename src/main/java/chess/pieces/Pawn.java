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
        // testa se existem movimentos possiveis para cima
        // ci,a
        if(this.getColor() == Color.WHITE) {
            p.setValues(position.getRow() - 1, position.getColumn());
            if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
                // marca como movimento possivel
                mat[p.getRow()][p.getColumn()] = true;

            }

            p.setValues(position.getRow() - 2, position.getColumn());
            Position p2 = new Position(position.getRow() - 1, position.getColumn());

            if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && getMoveCount() == 0 &&
                    getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p2)) {
                // marca como movimento possivel
                mat[p.getRow()][p.getColumn()] = true;

            }
            // teste se a  possição na diagonal é uma peça inimiga
            p.setValues(position.getRow() - 1, position.getColumn() -1);
            if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
                // marca como movimento possivel
                mat[p.getRow()][p.getColumn()] = true;

            }

            // teste se a  possição na diagonal é uma peça inimiga
            p.setValues(position.getRow() - 1, position.getColumn() + 1);
            if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
                // marca como movimento possivel
                mat[p.getRow()][p.getColumn()] = true;

            }
        } else {
            p.setValues(position.getRow() + 1, position.getColumn());
            if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
                // marca como movimento possivel
                mat[p.getRow()][p.getColumn()] = true;

            }

            p.setValues(position.getRow() + 2, position.getColumn());
            Position p2 = new Position(position.getRow() + 1, position.getColumn());

            if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && getMoveCount() == 0 &&
                    getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p2)) {
                // marca como movimento possivel
                mat[p.getRow()][p.getColumn()] = true;

            }
            // teste se a  possição na diagonal é uma peça inimiga
            p.setValues(position.getRow() + 1, position.getColumn() -1);
            if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
                // marca como movimento possivel
                mat[p.getRow()][p.getColumn()] = true;

            }

            // teste se a  possição na diagonal é uma peça inimiga
            p.setValues(position.getRow() + 1, position.getColumn() + 1);
            if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
                // marca como movimento possivel
                mat[p.getRow()][p.getColumn()] = true;

            }
        }


        return mat;
    }
}
