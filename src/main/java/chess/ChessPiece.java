package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;

public class ChessPiece extends Piece {
    private Color color;

    private Integer moveCount;


    // ======================================================================================

    public ChessPiece(Board board, Color color) {
        super(board);
        this.color = color;
    }

    // ======================================================================================


    public ChessPosition getChessPosition(){

        return null;
    }

    protected boolean isThereOpponentPiece(Position position){

        return false;
    }

    protected void increaseMoveCount(){
        this.moveCount++;
    }

    protected void decreaseMoveCount(){
        this.moveCount--;
    }

    // ++++++++++++++++++++++++++++-------------------------------------------------------

    public Color getColor() {
        return color;
    }

    private void setColor(Color color) {
        this.color = color;
    }

    public Integer getMoveCount() {
        return moveCount;
    }

    public void setMoveCount(Integer moveCount) {
        this.moveCount = moveCount;
    }
}
