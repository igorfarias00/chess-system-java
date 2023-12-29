package boardgame;

public class Piece {

    protected Position position;

    private Board board;

    // =============================================================================


    public Piece(Board board) {
        this.board = board;
        this.position = null;

    }

//    public Piece(Position position) {
//        this.position = position;
//    }

    // ============================================================================

    public boolean[][] possibleMoves(){

        return null;
    }

    public boolean possibleMove(Position position){

        return false;
    }

    public boolean isThereAnyPossibleMove(){

        return false;
    }


    // ++++++++++++++++++++++++++++++++++++++++--------------------------------------
    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    protected Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }
}
