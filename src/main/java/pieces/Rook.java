package main.java.pieces;

import main.java.NotMoveAllowedExecption;

import java.util.Optional;

/**
 * Created by najorcruzcruz on 9/5/16.
 */
public class Rook extends Piece {
    public Rook(String color, String position) {
        super(color, position, PieceType.ROOK);
    }

    @Override
    public void move(String to, Optional<Piece> toPiece) throws NotMoveAllowedExecption {

    }
}
