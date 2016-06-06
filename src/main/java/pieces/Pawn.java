package main.java.pieces;

import main.java.NotMoveAllowedExecption;

/**
 * Created by najorcruzcruz on 9/5/16.
 */
public class Pawn extends Piece {

    private Boolean firstMove = true;

    public Pawn(String color, String position) {
        super(color, position, PieceType.PAWN);
    }

    @Override
    public void move(String to, Piece toPiece) throws NotMoveAllowedExecption {
        if (getType() == PieceType.PAWN) {
            PieceMovements pieceMovements = new PieceMovements(getPosition(), to).invoke();
            int columnTo = pieceMovements.getColumnTo();
            int columnFrom = pieceMovements.getColumnFrom();
            int rowTo = pieceMovements.getRowTo();
            int rowFrom = pieceMovements.getRowFrom();

            if (columnTo == columnFrom && toPiece != null) {
                throw new NotMoveAllowedExecption("Square already occupied");
            }

            if (this.getColor().equals("white") && rowTo <= rowFrom) {
                throw new NotMoveAllowedExecption();
            }

            if (this.getColor().equals("black") && rowTo >= rowFrom) {
                throw new NotMoveAllowedExecption();
            }

            int distance = Math.abs(rowTo - rowFrom);
            int xDistance = Math.abs(columnTo - columnFrom);

            if ((!firstMove && distance > 1) || (firstMove && distance > 2) || distance <= 0) {
                throw new NotMoveAllowedExecption("Too much distance");
            }

            if (columnTo != columnFrom && distance == 1 && xDistance == 1 && toPiece != null) {
                toPiece.remove();
            } else if (columnTo != columnFrom) {
                throw new NotMoveAllowedExecption();
            }
        }

        firstMove = false;
        setPosition(to);
    }
}
