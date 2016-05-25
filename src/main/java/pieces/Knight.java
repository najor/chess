package main.java.pieces;

import main.java.NotMoveAllowedExecption;

/**
 * Created by najorcruzcruz on 9/5/16.
 */
public class Knight extends Piece {
    public Knight(String color, String position) {
        super(color, position, PieceType.KNIGHT);
    }

    @Override
    public void move(String to) throws NotMoveAllowedExecption {

    }
}
