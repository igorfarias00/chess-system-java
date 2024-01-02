package chess;


import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
import chess.pieces.*;

import java.util.ArrayList;
import java.util.List;

public class ChessMatch {

    private Board board;

    private Integer turn;

    private Color curentPlayer;

    private boolean check;

    private boolean checkMate;

    private ChessPiece enPassantVulnerable;

    private ChessPiece promoted;

    private List<Piece> piecesOnTheBoard = new ArrayList<>();

    private List<Piece> capturedPieces = new ArrayList<>();



    // =========================================================================

    public ChessMatch(){
        board = new Board(8,8);
        turn = 1;
        curentPlayer = Color.WHITE;
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

    private void nextTurn(){
        turn++;
        curentPlayer  = (curentPlayer == Color.WHITE) ? Color.BLACK : Color.WHITE;
    }

    private void initialSetup(){
        placeWhites();
        placeBlacks();

    }

    private void placeNewPiece(char column, int row, ChessPiece piece){
        board.placePiece(piece, new ChessPosition(column, row).toPosition());
        piecesOnTheBoard.add(piece);
    }

    private void placeWhites(){
        placeNewPiece('a', 1, new Rook(board, Color.WHITE));
        placeNewPiece('h', 1, new Rook(board, Color.WHITE));

        placeNewPiece('b', 1, new Knight(board, Color.WHITE));
        placeNewPiece('g', 1, new Knight(board, Color.WHITE));

        placeNewPiece('c', 1, new Bishop(board, Color.WHITE));
        placeNewPiece('f', 1, new Bishop(board, Color.WHITE));

        placeNewPiece('d', 1, new Queen(board, Color.WHITE));
        placeNewPiece('e', 1, new King(board, Color.WHITE));

        for (int i = 0; i < board.getColumns(); i++){
            placeNewPiece((char) ('a' + i), 2, new Pawn(board, Color.WHITE));
        }
    }

    private void placeBlacks(){
        placeNewPiece('a', 8, new Rook(board, Color.BLACK));
        placeNewPiece('h', 8, new Rook(board, Color.BLACK));

        placeNewPiece('b', 8, new Knight(board, Color.BLACK));
        placeNewPiece('g', 8, new Knight(board, Color.BLACK));

        placeNewPiece('c', 8, new Bishop(board, Color.BLACK));
        placeNewPiece('f', 8, new Bishop(board, Color.BLACK));

        placeNewPiece('d', 8, new Queen(board, Color.BLACK));
        placeNewPiece('e', 8, new King(board, Color.BLACK));

        for (int i = 0; i < board.getColumns(); i++){
            placeNewPiece((char) ('a' + i), 7, new Pawn(board, Color.BLACK));
        }
    }

    public boolean[][] possibleMoves(ChessPosition sourcePosition){
        Position position = sourcePosition.toPosition();
        validateSourcePosition(position);
        return board.piece(position).possibleMoves();

    }

    public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition){
        Position source = sourcePosition.toPosition();
        Position target = targetPosition.toPosition();

        validateSourcePosition(source);
        validateTargetPosition(source, target);

        Piece capturedPiece = makeMove(source, target);

        nextTurn();

        return (ChessPiece) capturedPiece;
    }



    private Piece makeMove(Position source, Position target) {
        Piece p = board.removePiece(source);
        Piece capturedPiece = board.removePiece(target);

        board.placePiece(p, target);

        if(capturedPiece != null){
            piecesOnTheBoard.remove(capturedPiece);
            capturedPieces.add(capturedPiece);
        }

        return capturedPiece;
    }

    private void validateSourcePosition(Position source) {
        if(!board.thereIsAPiece(source)){
            throw new ChessException("There is no piece on source position!");
        }
        if(curentPlayer != ((ChessPiece)board.piece(source)).getColor() ){
            throw new ChessException("The chosen piece is not yours");
        }
        if(!board.piece(source).isThereAnyPossibleMove()){
            throw new ChessException("There is no possible moves for the chosen piece!");
        }
    }

    private void validateTargetPosition(Position source, Position target) {
        if(!board.piece(source).possibleMove(target)){
            throw new ChessException("The chosen piece can't move to target Position!");
        }
    }

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

    public Color getCurentPlayer() {
        return curentPlayer;
    }

    public void setCurentPlayer(Color curentPlayer) {
        this.curentPlayer = curentPlayer;
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
