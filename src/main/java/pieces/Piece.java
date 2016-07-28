package main.java.pieces;

import com.sun.istack.internal.Nullable;
import main.java.NotMoveAllowedExecption;
import main.java.chess.Board;
import main.java.utils.TriFunction;

/**
 * Created by najorcruzcruz on 11/4/16.
 */
public abstract class Piece {

    protected final Board board;
    private String color;
    private String position;
    private PieceType type;
    private Boolean isRemoved;

    public Piece(String color, String position, PieceType type, Board board) {
        this.color = color;
        this.position = position;
        this.type = type;
        this.board = board;
        isRemoved = false;
    }

    public void checkCorrectMove(PieceMovements pieceMovements, TriFunction<Integer, Integer, Integer, String> moveFn) throws NotMoveAllowedExecption {
        int startCol = pieceMovements.getColumnTo();
        int endCol = pieceMovements.getColumnFrom();
        int endRow = pieceMovements.getRowTo();
        int startRow = pieceMovements.getRowFrom();

        if (startRow > endRow) {
            int aux = startRow;
            startRow = endRow;
            endRow = aux;
        }

        if (startCol > endCol) {
            int aux = startCol;
            startCol = endCol;
            endCol = aux;
        }

        int start = startRow;
        int end = endRow;

        if (startRow == endRow) {
            start = startCol;
            end = endCol;
        }

        int step = 1;
        while ((start + step) < end) {
            String move = moveFn.apply(startCol, startRow, step);
            if (board.getPiece(move) != null) {
                throw new NotMoveAllowedExecption("There is a piece in the middle");
            }
            step++;
        }
    }

    public boolean isNotRemoved() {
        return !isRemoved;
    }

    public boolean isRemoved() {
        return isRemoved;
    }

    public void remove() {
        isRemoved = true;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public PieceType getType() {
        return type;
    }

    public void setType(PieceType type) {
        this.type = type;
    }

    public void move(String to) throws NotMoveAllowedExecption {
        if (isPieceSameColor(board.getPiece(to))) {
            throw new NotMoveAllowedExecption("Move to an occupied square. (SAME COLOUR AS YOURS)");
        }

        makeMove(to);
        removePiece(to);
        setPosition(to);
    }

    private void removePiece(String to) {
        Piece toPiece = board.getPiece(to);
        if (toPiece != null) {
            toPiece.remove();
        }
    }

    private boolean isPieceSameColor(@Nullable Piece toPiece) {
        return toPiece != null && this.getColor().equals(toPiece.getColor());
    }

    protected abstract void makeMove(String to) throws NotMoveAllowedExecption;

    @Override
    public String toString() {
        if (getType() == PieceType.KING || getType() == PieceType.QUEEN)
            return getColor().charAt(0) + "" + getType().name().toUpperCase().charAt(0);
        return getColor().charAt(0) + "" + getType().name().toLowerCase().charAt(0);
    }
}
