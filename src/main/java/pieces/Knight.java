package main.java.pieces;

import main.java.NotMoveAllowedExecption;
import main.java.chess.Board;

/**
 * Created by najorcruzcruz on 9/5/16.
 */
public class Knight extends Piece {
    public Knight(String color, String position, Board board) {
        super(color, position, PieceType.KNIGHT, board);
    }

    @Override
    public void makeMove(String to) throws NotMoveAllowedExecption {

        Piece toPiece = board.getPiece(to);
        PieceMovements pieceMovements = new PieceMovements(getPosition(), to).invoke();
        int columnTo = pieceMovements.getColumnTo();
        int columnFrom = pieceMovements.getColumnFrom();
        int rowTo = pieceMovements.getRowTo();
        int rowFrom = pieceMovements.getRowFrom();

        int diffColumn = Math.abs(columnFrom - columnTo);
        int diffFrom = Math.abs(rowTo - rowFrom);

        if (diffColumn > 2 || diffFrom > 2) {
            throw new NotMoveAllowedExecption();
        }

        if (toPiece != null) {
            toPiece.remove();
        }
    }
}
