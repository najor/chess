package main.java.pieces;

import com.sun.istack.internal.Nullable;
import main.java.NotMoveAllowedExecption;

/**
 * Created by najorcruzcruz on 11/4/16.
 */
public abstract class Piece {

    private String color;
    private String position;
    private PieceType type;
    private Boolean isRemoved;

    public Piece(String color, String position, PieceType type) {
        this.color = color;
        this.position = position;
        this.type = type;
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
        move(to, null);
    }

    public abstract void move(String to, @Nullable Piece toPiece) throws NotMoveAllowedExecption;

    @Override
    public String toString() {
        if (getType() == PieceType.KING || getType() == PieceType.QUEEN)
            return getColor().charAt(0) + "" + getType().name().toUpperCase().charAt(0);
        return getColor().charAt(0) + "" + getType().name().toLowerCase().charAt(0);
    }
}
