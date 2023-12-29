package chess;


import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
import chess.pieces.*;

public class ChessMatch {

    private Board board;



    private Integer turn;

    private Color cuurentPlayer;

    private boolean check;

    private boolean checkMate;

    private ChessPiece enPassantVulnerable;

    private ChessPiece promoted;


    // =========================================================================

    public ChessMatch(){
        board = new Board(8,8);
        initialSetup();

    }


    // =========================================================================

    public ChessPiece[][] getPieces(){
        ChessPiece[][] pieces = new ChessPiece[board.getRows()][board.getColumns()];

        for(int i=0; i< board.getRows(); i++){
            for (int j = 0; j < board.getColumns(); j++){
                pieces[i][j] = (ChessPiece) board.piece(i, j);
            }
        }

        return pieces;
    }

    private void initialSetup(){
        placeWhites();
        placeBlacks();

    }

    private void placeWhites(){
        board.placePiece(new Rook(board, Color.WHITE), new Position(0,0));
        board.placePiece(new Rook(board, Color.WHITE), new Position(0,7));

        board.placePiece(new Knight(board, Color.WHITE), new Position(0,1));
        board.placePiece(new Knight(board, Color.WHITE), new Position(0,6));

        board.placePiece(new Bishop(board, Color.WHITE), new Position(0,2));
        board.placePiece(new Bishop(board, Color.WHITE), new Position(0,5));

        board.placePiece(new Queen(board, Color.WHITE), new Position(0,3));
        board.placePiece(new King(board, Color.WHITE), new Position(0,4));

        for (int i = 0; i < board.getColumns(); i++){
            board.placePiece(new Pawn(board, Color.WHITE), new Position(1, i));
        }
    }

    private void placeBlacks(){
        board.placePiece(new Rook(board, Color.BLACK), new Position(board.getRows()-1,0));
        board.placePiece(new Rook(board, Color.BLACK), new Position(board.getRows()-1, 7));

        board.placePiece(new Knight(board, Color.BLACK), new Position(board.getRows()-1,1));
        board.placePiece(new Knight(board, Color.BLACK), new Position(board.getRows()-1,6));

        board.placePiece(new Bishop(board, Color.BLACK), new Position(board.getRows()-1,2));
        board.placePiece(new Bishop(board, Color.BLACK), new Position(board.getRows()-1,5));

        board.placePiece(new Queen(board, Color.BLACK), new Position(board.getRows()-1,3));
        board.placePiece(new King(board, Color.BLACK), new Position(board.getRows()-1,4));

        for (int i = 0; i < board.getColumns(); i++){
            board.placePiece(new Pawn(board, Color.BLACK), new Position(board.getRows()-2, i));
        }
    }

//    public boolean[][] possibleMoves(ChessPosition sourcePosition){
//
//    }

//    public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition){
//
//    }

//    public ChessPiece replacePromotedPiece(String type){
//
//    }


    //+++++++++++++++++++++++++++++++++++_-------------------------------------


    public Integer getTurn() {
        return turn;
    }

    public void setTurn(Integer turn) {
        this.turn = turn;
    }

    public Color getCuurentPlayer() {
        return cuurentPlayer;
    }

    public void setCuurentPlayer(Color cuurentPlayer) {
        this.cuurentPlayer = cuurentPlayer;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    public boolean isCheckMate() {
        return checkMate;
    }

    public void setCheckMate(boolean checkMate) {
        this.checkMate = checkMate;
    }

    public ChessPiece getEnPassantVulnerable() {
        return enPassantVulnerable;
    }

    public void setEnPassantVulnerable(ChessPiece enPassantVulnerable) {
        this.enPassantVulnerable = enPassantVulnerable;
    }

    public ChessPiece getPromoted() {
        return promoted;
    }

    public void setPromoted(ChessPiece promoted) {
        this.promoted = promoted;
    }
}
