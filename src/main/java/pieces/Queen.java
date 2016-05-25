package main.java.pieces;

import main.java.NotMoveAllowedExecption;

/**
 * Created by najorcruzcruz on 9/5/16.
 */
public class Queen extends Piece {
    public Queen(String color, String position) {
        super(color, position, PieceType.QUEEN);
    }

    @Override
    public void move(String to) throws NotMoveAllowedExecption {

    }
}
