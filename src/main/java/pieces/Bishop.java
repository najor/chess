package main.java.pieces;

import main.java.NotMoveAllowedExecption;
import main.java.chess.Board;

/**
 * Created by najorcruzcruz on 9/5/16.
 */
public class Bishop extends Piece {

    public Bishop(String color, String position, Board board) {
        super(color, position, PieceType.BISHOP, board);
    }

    @Override
    public void makeMove(String to) throws NotMoveAllowedExecption {

    }
}
