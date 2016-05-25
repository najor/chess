package main.java.pieces;

import main.java.NotMoveAllowedExecption;

/**
 * Created by najorcruzcruz on 11/4/16.
 */
public abstract class Piece {

    private String color;
    private String position;
    private PieceType type;

    public Piece(String color, String position, PieceType type) {
        this.color = color;
        this.position = position;
        this.type = type;
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

    public abstract void move(String to) throws NotMoveAllowedExecption;

    @Override
    public String toString() {
        if (getType() == PieceType.KING || getType() == PieceType.QUEEN)
            return getColor().charAt(0) + "" + getType().name().toUpperCase().charAt(0);
        return getColor().charAt(0) + "" + getType().name().toLowerCase().charAt(0);
    }
}
