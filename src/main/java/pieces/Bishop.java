package main.java.pieces;

import main.java.exception.NotMoveAllowedException;
import main.java.chess.Board;

/**
 * Created by najorcruzcruz on 9/5/16.
 */
public class Bishop extends Piece {

    public Bishop(String color, String position, Board board) {
        super(color, position, PieceType.BISHOP, board);
    }

    @Override
    public void makeMove(String to) throws NotMoveAllowedException {
        PieceMovements pieceMovements = new PieceMovements(getPosition(), to).invoke();

        if (!isDiagonalMove(pieceMovements)) {
            throw new NotMoveAllowedException("Only Diagonal moves are allowed");
        }

        checkCorrectMove(pieceMovements, (col, row, step) -> ((char)(col + step)) + "" + (row + step));
    }

    private boolean isDiagonalMove(PieceMovements pieceMovements) {
        int diffColumn = Math.abs(pieceMovements.getColumnFrom() - pieceMovements.getColumnTo());
        int diffRow = Math.abs(pieceMovements.getRowFrom() - pieceMovements.getRowTo());

        return diffColumn == diffRow && diffColumn != 0;
    }
}
