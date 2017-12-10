package main.java.chess;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import main.java.exception.NotMoveAllowedException;
import main.java.exception.NotPieceFoundException;
import main.java.pieces.Bishop;
import main.java.pieces.King;
import main.java.pieces.Knight;
import main.java.pieces.Pawn;
import main.java.pieces.Piece;
import main.java.pieces.Queen;
import main.java.pieces.Rook;

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
        board = new Board();
        playerWhite = new Player(getPiecesWhite());
        playerBlack = new Player(getPiecesBlack());
        board.setPlayerBlack(playerBlack);
        board.setPlayerWhite(playerWhite);
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

    public Piece move(String color, String from, String to) throws NotMoveAllowedException, NotPieceFoundException {
        Optional<Piece> pieceFrom;

        if (color.equals("white")) {
            pieceFrom = playerWhite.getPiece(from);
        } else {
            pieceFrom = playerBlack.getPiece(from);
        }

        if (pieceFrom.isPresent()) {
            pieceFrom.get().move(to);
        } else {
            throw new NotPieceFoundException();
        }

        return pieceFrom.get();
    }

    private List<Piece> getPiecesWhite() {
        ArrayList pieces = new ArrayList<>();

        String color = "white";

        pieces.add(new Rook(color, "A1", board));
        pieces.add(new Knight(color, "B1", board));
        pieces.add(new Bishop(color, "C1", board));
        pieces.add(new Queen(color, "D1", board));
        pieces.add(new King(color, "E1", board));
        pieces.add(new Bishop(color, "F1", board));
        pieces.add(new Knight(color, "G1", board));
        pieces.add(new Rook(color, "H1", board));

        pieces.add(new Pawn(color, "A2", board));
        pieces.add(new Pawn(color, "B2", board));
        pieces.add(new Pawn(color, "C2", board));
        pieces.add(new Pawn(color, "D2", board));
        pieces.add(new Pawn(color, "E2", board));
        pieces.add(new Pawn(color, "F2", board));
        pieces.add(new Pawn(color, "G2", board));
        pieces.add(new Pawn(color, "H2", board));

        return pieces;
    }

    private List<Piece> getPiecesBlack() {
        ArrayList pieces = new ArrayList<>();

        String color = "black";

        pieces.add(new Rook(color, "A8", board));
        pieces.add(new Knight(color, "B8", board));
        pieces.add(new Bishop(color, "C8", board));
        pieces.add(new Queen(color, "D8", board));
        pieces.add(new King(color, "E8", board));
        pieces.add(new Bishop(color, "F8", board));
        pieces.add(new Knight(color, "G8", board));
        pieces.add(new Rook(color, "H8", board));

        pieces.add(new Pawn(color, "A7", board));
        pieces.add(new Pawn(color, "B7", board));
        pieces.add(new Pawn(color, "C7", board));
        pieces.add(new Pawn(color, "D7", board));
        pieces.add(new Pawn(color, "E7", board));
        pieces.add(new Pawn(color, "F7", board));
        pieces.add(new Pawn(color, "G7", board));
        pieces.add(new Pawn(color, "H7", board));

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
