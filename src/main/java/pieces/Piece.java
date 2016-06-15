package main.java.pieces;

import com.sun.istack.internal.Nullable;
import main.java.NotMoveAllowedExecption;
import main.java.chess.Board;

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
            throw new NotMoveAllowedExecption("Move to an occupied square. (SAME COLOUR AS YOUR)");
        }
        makeMove(to);
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
