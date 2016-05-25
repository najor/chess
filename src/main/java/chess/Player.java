package main.java.chess;

import main.java.pieces.Piece;

import java.util.List;
import java.util.Optional;

/**
 * Created by najorcruzcruz on 11/4/16.
 */
public class Player {

    private Board board;
    private List<Piece> pieces;

    public Player(Board board, String color, List<Piece> pieces) {
        this.board = board;

        this.pieces = pieces;
    }

    public Optional<Piece> getPiece(String position) {
        return pieces.stream()
                .filter(piece -> piece.getPosition().equals(position))
                .findFirst();

    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Piece> getPieces() {
        return pieces;
    }

    public void setPieces(List<Piece> pieces) {
        this.pieces = pieces;
    }
}
