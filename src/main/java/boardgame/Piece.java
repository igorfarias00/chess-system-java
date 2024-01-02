package boardgame;

public abstract class Piece {

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

    public abstract boolean[][] possibleMoves();

    public boolean possibleMove(Position position){

        return possibleMoves()[position.getRow()][position.getColumn()];
    }

    public boolean isThereAnyPossibleMove(){
        boolean[][] possibleMoves = possibleMoves();

        for(int i = 0; i < possibleMoves.length; i++){
            for(int j = 0; j < possibleMoves[i].length; j++){
                if (possibleMoves[i][j]){
                    return true;
                }
            }
        }
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
