package main.java.pieces;

import main.java.NotMoveAllowedExecption;
import main.java.chess.Board;

import java.util.function.BiFunction;

/**
 * Created by najorcruzcruz on 9/5/16.
 */
public class Rook extends Piece {
    public Rook(String color, String position, Board board) {
        super(color, position, PieceType.ROOK, board);
    }

    @Override
    public void makeMove(String to) throws NotMoveAllowedExecption {
        PieceMovements pieceMovements = new PieceMovements(getPosition(), to).invoke();
        int columnTo = pieceMovements.getColumnTo();
        int columnFrom = pieceMovements.getColumnFrom();
        int rowTo = pieceMovements.getRowTo();
        int rowFrom = pieceMovements.getRowFrom();

        if (columnFrom == columnTo) {
            checkCorrectMove(columnFrom, rowTo, rowFrom, (fixed, move) -> ((char)fixed.intValue()) + "" + move);
        } else if (rowFrom == rowTo) {
            checkCorrectMove(rowFrom, columnFrom, columnTo, (fixed, move) -> ((char)move.intValue()) + "" + fixed);
        } else {
            throw new NotMoveAllowedExecption();
        }
    }

    private void checkCorrectMove(int fixed, int to, int from, BiFunction<Integer, Integer, String> moveFn) throws NotMoveAllowedExecption {
        int movement = from;
        int end = to;

        if (movement > end) {
            movement = to;
            end = from;
        }

        movement++;
        while (movement < end) {
            String move = moveFn.apply(fixed, movement);
            if (this.board.getPiece(move) != null) {
                throw new NotMoveAllowedExecption("There is a piece in the middle");
            }
            movement++;
        }
    }
}
