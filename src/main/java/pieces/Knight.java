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
    public void move(String to, Piece toPiece) throws NotMoveAllowedExecption {

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

        setPosition(to);
    }
}
