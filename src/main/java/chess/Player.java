package main.java.chess;

import java.util.List;
import java.util.Optional;

import main.java.pieces.Piece;

/**
 * Created by najorcruzcruz on 11/4/16.
 */
public class Player {

    private List<Piece> pieces;

    Player(List<Piece> pieces) {
        this.pieces = pieces;
    }

    public Optional<Piece> getPiece(String position) {
        return pieces.stream()
                .filter(Piece::isNotRemoved)
                .filter(piece -> piece.getPosition().toUpperCase().equals(position.toUpperCase()))
                .findFirst();

    }

    public List<Piece> getPieces() {
        return pieces;
    }

    public void setPieces(List<Piece> pieces) {
        this.pieces = pieces;
    }
}
