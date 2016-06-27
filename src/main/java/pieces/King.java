package main.java.pieces;

import main.java.NotMoveAllowedExecption;
import main.java.chess.Board;

/**
 * Created by najorcruzcruz on 9/5/16.
 */
public class King extends Piece {
    public King(String color, String position, Board board) {
        super(color, position, PieceType.KING, board);
    }

    @Override
    public void makeMove(String to) throws NotMoveAllowedExecption {
        PieceMovements pieceMovements = new PieceMovements(getPosition(), to).invoke();
        int columnTo = pieceMovements.getColumnTo();
        int columnFrom = pieceMovements.getColumnFrom();
        int rowTo = pieceMovements.getRowTo();
        int rowFrom = pieceMovements.getRowFrom();

        int rowDistance = Math.abs(rowTo - rowFrom);
        int columnDistance = Math.abs(columnTo - columnFrom);

        if (rowDistance > 1 || columnDistance > 1) {
            throw new NotMoveAllowedExecption("The king can only move 1 position");
        }

        Piece toPiece = board.getPiece(to);
        if (toPiece != null) {
            toPiece.remove();
        }
    }
}
