package boardgame;

public class Piece {
    protected Position position;

    // =============================================================================

    public Piece(Position position) {
        this.position = position;
    }

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
}
