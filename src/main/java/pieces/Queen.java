package main.java.pieces;

import main.java.NotMoveAllowedExecption;
import main.java.chess.Board;

/**
 * Created by najorcruzcruz on 9/5/16.
 */
public class Queen extends Piece {
    public Queen(String color, String position, Board board) {
        super(color, position, PieceType.QUEEN, board);
    }

    @Override
    public void makeMove(String to) throws NotMoveAllowedExecption {

    }
}
