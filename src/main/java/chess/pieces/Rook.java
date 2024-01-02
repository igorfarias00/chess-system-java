package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Rook extends ChessPiece {
    public Rook(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString(){
        return "R";
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

        // ==============================================================
        // Baixo
        // testa se existem movimentos possiveis para baixo
        p.setValues(position.getRow() + 1, position.getColumn());

        while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){
            // marca como movimento possivel
            mat[p.getRow()][p.getColumn()] = true;
            p.setRow(p.getRow() + 1);

        }
        // teste se a ultima possição para cima é uma peça inimiga
        if(getBoard().positionExists(p) && isThereOpponentPiece(p)){
            // marca como movimento possivel
            mat[p.getRow()][p.getColumn()] = true;
        }


        // ==============================================================
        // esquerda
        // testa se existem movimentos possiveis para esquerda
        p.setValues(position.getRow(), position.getColumn() - 1);

        while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){
            // marca como movimento possivel
            mat[p.getRow()][p.getColumn()] = true;
            p.setColumn(p.getColumn() - 1);

        }
        // teste se a ultima possição para cima é uma peça inimiga
        if(getBoard().positionExists(p) && isThereOpponentPiece(p)){
            // marca como movimento possivel
            mat[p.getRow()][p.getColumn()] = true;
        }

        // ==============================================================
        // direita
        // testa se existem movimentos possiveis para Direita
        p.setValues(position.getRow(), position.getColumn() + 1);

        while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){
            // marca como movimento possivel
            mat[p.getRow()][p.getColumn()] = true;
            p.setColumn(p.getColumn() + 1);

        }
        // teste se a ultima possição para cima é uma peça inimiga
        if(getBoard().positionExists(p) && isThereOpponentPiece(p)){
            // marca como movimento possivel
            mat[p.getRow()][p.getColumn()] = true;
        }

        return mat;
    }
}
