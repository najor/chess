package main.java.chess;

import main.java.NotMoveAllowedExecption;
import main.java.NotPieceFoundException;
import main.java.pieces.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by najorcruzcruz on 11/4/16.
 */
public class Chess {

    private Player playerWhite;
    private Player playerBlack;
    private Board board;

    public static Chess createGame() {
        return new Chess();
    }

    private Chess() {
        playerWhite = new Player(board, "white", getPiecesWhite());
        playerBlack = new Player(board, "black", getPiecesBlack());
        board = new Board(playerWhite, playerBlack);
    }


    public Player getPlayerWhite() {
        return playerWhite;
    }

    public void printBoard() {
        int charCode = 65;
        System.out.println();
        System.out.println("    A  B  C  D  E  F  G  H");
        for (int i = 8; i >= 1; i--) {
            System.out.print(" " + i + "  ");
            for (int j = 0; j < 8; j++) {
                String position = (char) (charCode + j) + "" + i;

                Piece piece = getPiece(position);
                System.out.print(piece == null ? "__" : piece.toString());
                System.out.print(" ");
            }
            System.out.print("  " + i + " ");
            System.out.println();
        }

        System.out.println("    A  B  C  D  E  F  G  H");
    }

    public Piece getPiece(String position) {
        Optional<Piece> pieceWhite = playerWhite.getPiece(position);
        Optional<Piece> pieceBlack = playerBlack.getPiece(position);

        if (pieceWhite.isPresent()) {
            return pieceWhite.get();
        } else if (pieceBlack.isPresent()) {
            return pieceBlack.get();
        }

        return null;
    }

    public Piece move(String color, String from, String to) throws NotMoveAllowedExecption, NotPieceFoundException {
        Optional<Piece> pieceFrom;
        Optional<Piece> pieceTo;

        if (color.equals("white")) {
            pieceFrom = playerWhite.getPiece(from);
            pieceTo = playerBlack.getPiece(to);
        } else {
            pieceFrom = playerBlack.getPiece(from);
            pieceTo = playerWhite.getPiece(to);
        }

        if (pieceFrom.isPresent()) {
            if (pieceTo.isPresent()) {
                pieceFrom.get().move(to, pieceTo.get());
            } else {
                pieceFrom.get().move(to);
            }
        } else {
            throw new NotPieceFoundException();
        }

        return pieceFrom.get();
    }

    private List<Piece> getPiecesWhite() {
        ArrayList pieces = new ArrayList<>();

        String color = "white";

        pieces.add(new Rook(color, "A1"));
        pieces.add(new Knight(color, "B1"));
        pieces.add(new Bishop(color, "C1"));
        pieces.add(new Queen(color, "D1"));
        pieces.add(new King(color, "E1"));
        pieces.add(new Bishop(color, "F1"));
        pieces.add(new Knight(color, "G1"));
        pieces.add(new Rook(color, "H1"));

        pieces.add(new Pawn(color, "A2"));
        pieces.add(new Pawn(color, "B2"));
        pieces.add(new Pawn(color, "C2"));
        pieces.add(new Pawn(color, "D2"));
        pieces.add(new Pawn(color, "E2"));
        pieces.add(new Pawn(color, "F2"));
        pieces.add(new Pawn(color, "G2"));
        pieces.add(new Pawn(color, "H2"));

        return pieces;
    }

    private List<Piece> getPiecesBlack() {
        ArrayList pieces = new ArrayList<>();

        String color = "black";

        pieces.add(new Rook(color, "A8"));
        pieces.add(new Knight(color, "B8"));
        pieces.add(new Bishop(color, "C8"));
        pieces.add(new Queen(color, "D8"));
        pieces.add(new King(color, "E8"));
        pieces.add(new Bishop(color, "F8"));
        pieces.add(new Knight(color, "G8"));
        pieces.add(new Rook(color, "H8"));

        pieces.add(new Pawn(color, "A7"));
        pieces.add(new Pawn(color, "B7"));
        pieces.add(new Pawn(color, "C7"));
        pieces.add(new Pawn(color, "D7"));
        pieces.add(new Pawn(color, "E7"));
        pieces.add(new Pawn(color, "F7"));
        pieces.add(new Pawn(color, "G7"));
        pieces.add(new Pawn(color, "H7"));

        return pieces;
    }

    public void setPlayerWhite(Player playerWhite) {
        this.playerWhite = playerWhite;
    }

    public Player getPlayerBlack() {
        return playerBlack;
    }

    public void setPlayerBlack(Player playerBlack) {
        this.playerBlack = playerBlack;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }
}
