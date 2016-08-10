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
        PieceMovements pieceMovements = new PieceMovements(getPosition(), to).invoke();
        int columnTo = pieceMovements.getColumnTo();
        int columnFrom = pieceMovements.getColumnFrom();
        int rowTo = pieceMovements.getRowTo();
        int rowFrom = pieceMovements.getRowFrom();

        if (columnFrom == columnTo) {
            checkCorrectMove(pieceMovements, (col, row, step) -> ((char)col.intValue()) + "" + (row + step));
        } else if (rowFrom == rowTo) {
            checkCorrectMove(pieceMovements, (col, row, step) -> ((char)(col + step)) + "" + row);
        } else {
            checkCorrectMove(pieceMovements, (col, row, step) -> ((char) (col + step)) + "" + (row + step));
        }
    }
}
