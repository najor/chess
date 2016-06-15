package main.java.chess;

import main.java.pieces.Piece;

import java.util.Optional;

/**
 * Created by najorcruzcruz on 11/4/16.
 */
public class Board {

    private Player playerWhite;
    private Player playerBlack;

    public Board() {

    }

    public Board(Player playerWhite, Player playerBlack) {
        this.playerBlack = playerBlack;
        this.playerWhite = playerWhite;
    }

    public Piece getPiece(String position) {
        Optional<Piece> pieceBlack = playerBlack.getPiece(position);
        Optional<Piece> pieceWhite = playerWhite.getPiece(position);
        if (pieceBlack.isPresent()) {
            return pieceBlack.get();
        } else if (pieceWhite.isPresent()) {
            return pieceWhite.get();
        }
        return null;
    }

    public void setPlayerWhite(Player playerWhite) {
        this.playerWhite = playerWhite;
    }

    public void setPlayerBlack(Player playerBlack) {
        this.playerBlack = playerBlack;
    }
}
