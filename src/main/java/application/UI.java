package application;

import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;
import chess.Color;

import java.io.IOException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class UI {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void printMatch(ChessMatch chessMatch, List<ChessPiece> captured){
        printCapturedWhitePieces(captured);
        printBoard(chessMatch.getPieces());
        printCapturedBlackPieces(captured);
        System.out.println();

        System.out.println("Turn: " + chessMatch.getTurn());

        if(!chessMatch.isCheckMate()) {
            System.out.println("Waiting player: " + chessMatch.getCurentPlayer());
            if (chessMatch.isCheck()) {
                System.out.println("CHECK!");
            }
        } else {
            System.out.println("CHECKMATE!");
            System.out.println("Winner: " + chessMatch.getCurentPlayer());
        }

    }

    public static void printBoard(ChessPiece[][] pieces){

        System.out.println("  _____________________");

        for(int i=0; i< pieces.length; i++){
            System.out.print(8 - i + " || ");

            for (int j = 0; j < pieces[i].length; j++){
                printPiece(pieces[i][j]);

            }

            System.out.println("||");
        }
        System.out.println("  ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
        System.out.println("     A B C D E F G H");
    }

    public static void printBoard(ChessPiece[][] pieces, boolean[][] possibleMoves){

        System.out.println("  _____________________");

        for(int i=0; i< pieces.length; i++){
            System.out.print(8 - i + " || ");

            for (int j = 0; j < pieces[i].length; j++){
                printPiece(pieces[i][j], possibleMoves[i][j]);
            }

            System.out.println("||");
        }
        System.out.println("  ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
        System.out.println("     A B C D E F G H");
    }


    private static void printPiece(ChessPiece piece){
        if(piece == null){
            System.out.print("-");

        } else {
            if( piece.getColor() == Color.WHITE ) {
                System.out.print(ANSI_BLACK  + ANSI_WHITE_BACKGROUND + piece + ANSI_RESET);
            } else {
                System.out.print(ANSI_WHITE + ANSI_BLACK_BACKGROUND +piece + ANSI_RESET);
            }

        }

        System.out.print(" ");
    }
    private static void printPiece(ChessPiece piece, boolean possibleMove){
        if(possibleMove){
            System.out.print(ANSI_BLUE_BACKGROUND);
        }

        if(piece == null){
            System.out.print("-");

        } else if(!possibleMove){
            if( piece.getColor() == Color.WHITE ) {
                System.out.print(ANSI_BLACK  + ANSI_WHITE_BACKGROUND + piece + ANSI_RESET);
            } else {
                System.out.print(ANSI_WHITE + ANSI_BLACK_BACKGROUND +piece + ANSI_RESET);
            }

        } else {
            if( piece.getColor() == Color.WHITE ) {
                System.out.print(ANSI_BLACK  + piece + ANSI_RESET);
            } else {
                System.out.print(ANSI_WHITE  +piece + ANSI_RESET);
            }
        }

        if(possibleMove){
            System.out.print(ANSI_RESET);
        }

        System.out.print(" ");
    }

    public static ChessPosition readChessPosition(Scanner sc){
        try {
            String s = sc.nextLine();
            char column = s.charAt(0);
            int row = Integer.parseInt(s.substring(1));

            return new ChessPosition(column, row);
        } catch (RuntimeException e) {
            throw new InputMismatchException("Error reading ChessPosition. valid values are from a1 to h8. " + e);

        }


    }

    private static void printCapturedPieces(List<ChessPiece> capturadas){
        List<ChessPiece> brancas = capturadas.stream().filter(x -> x.getColor() == Color.WHITE).toList();
        List<ChessPiece> pretas = capturadas.stream().filter(x -> x.getColor() == Color.BLACK).toList();

        System.out.println("Captured pieces: ");

        System.out.println("Brancas: ");
        System.out.print(ANSI_BLACK + ANSI_WHITE_BACKGROUND);
        System.out.println(Arrays.toString(brancas.toArray()) + ANSI_RESET);

        System.out.println("||======================================||");

        System.out.println("Pretas: ");
        System.out.print(ANSI_WHITE + ANSI_BLACK_BACKGROUND);
        System.out.println(Arrays.toString(pretas.toArray()) + ANSI_RESET) ;


    }

    private static void printCapturedWhitePieces(List<ChessPiece> capturadas){
        List<ChessPiece> brancas = capturadas.stream().filter(x -> x.getColor() == Color.WHITE).toList();

        System.out.println("Peças Brancas Capturadas: ");
        System.out.print(ANSI_BLACK + ANSI_WHITE_BACKGROUND);
        System.out.println(Arrays.toString(brancas.toArray()) + ANSI_RESET);



    }

    private static void printCapturedBlackPieces(List<ChessPiece> capturadas){
        List<ChessPiece> pretas = capturadas.stream().filter(x -> x.getColor() == Color.BLACK).toList();


        System.out.println("Peças Pretas Capturadas: ");
        System.out.print(ANSI_WHITE + ANSI_BLACK_BACKGROUND);
        System.out.println(Arrays.toString(pretas.toArray()) + ANSI_RESET) ;



    }
}
