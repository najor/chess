package main.java.pieces;

import main.java.exception.NotMoveAllowedException;
import main.java.chess.Board;

/**
 * Created by najorcruzcruz on 9/5/16.
 */
public class Pawn extends Piece {

    private Boolean firstMove = true;

    public Pawn(String color, String position, Board board) {
        super(color, position, PieceType.PAWN, board);
    }

    @Override
    public void makeMove(String to) throws NotMoveAllowedException {
        if (getType() == PieceType.PAWN) {
            Piece toPiece = this.board.getPiece(to);
            PieceMovements pieceMovements = new PieceMovements(getPosition(), to).invoke();
            int columnTo = pieceMovements.getColumnTo();
            int columnFrom = pieceMovements.getColumnFrom();
            int rowTo = pieceMovements.getRowTo();
            int rowFrom = pieceMovements.getRowFrom();

            if (columnTo == columnFrom && toPiece != null) {
                throw new NotMoveAllowedException("Square already occupied");
            }

            if (this.getColor().equals("white") && rowTo <= rowFrom) {
                throw new NotMoveAllowedException();
            }

            if (this.getColor().equals("black") && rowTo >= rowFrom) {
                throw new NotMoveAllowedException();
            }

            int rowDistance = Math.abs(rowTo - rowFrom);
            int columnDistance = Math.abs(columnTo - columnFrom);

            if ((!firstMove && rowDistance > 1) || (firstMove && rowDistance > 2) || rowDistance <= 0) {
                throw new NotMoveAllowedException("Too much distance");
            }

            if (columnTo != columnFrom && rowDistance == 1 && columnDistance == 1 && toPiece != null) {
                toPiece.remove();
            } else if (columnTo != columnFrom) {
                throw new NotMoveAllowedException();
            }
        }

        firstMove = false;
    }
}
