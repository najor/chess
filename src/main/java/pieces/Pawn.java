package main.java.pieces;

import main.java.NotMoveAllowedExecption;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by najorcruzcruz on 9/5/16.
 */
public class Pawn extends Piece {

    private Boolean firstMove = true;

    public Pawn(String color, String position) {
        super(color, position, PieceType.PAWN);
    }

    @Override
    public void move(String to, Optional<Piece> toPiece) throws NotMoveAllowedExecption {
        if (getType() == PieceType.PAWN) {
            Pattern p = Pattern.compile("(\\w)(\\d)");
            Matcher matcherDestiny = p.matcher(to);
            if (!matcherDestiny.matches()) {
                throw new NotMoveAllowedExecption("Destiny is not well constructed");
            }

            char xDest = matcherDestiny.group(1).charAt(0);
            int numDest = Integer.parseInt(matcherDestiny.group(2));

            if (!matcherDestiny.matches()) {
                throw new NotMoveAllowedExecption();
            }

            matcherDestiny = p.matcher(getPosition());

            if (!matcherDestiny.matches()) {
                throw new NotMoveAllowedExecption();
            }

            char xFrom = matcherDestiny.group(1).charAt(0);
            int numFrom = Integer.parseInt(matcherDestiny.group(2));

            if (xDest == xFrom && toPiece.isPresent()) {
                throw new NotMoveAllowedExecption("Square already occupied");
            }

            if (this.getColor().equals("white") && numDest <= numFrom) {
                throw new NotMoveAllowedExecption();
            }

            if (this.getColor().equals("black") && numDest >= numFrom) {
                throw new NotMoveAllowedExecption();
            }

            int distance = Math.abs(numDest - numFrom);
            int xDistance = Math.abs(Character.getNumericValue(xDest) - Character.getNumericValue(xFrom));

            if ((!firstMove && distance > 1) || (firstMove && distance > 2) || distance <= 0) {
                throw new NotMoveAllowedExecption("Too much distance");
            }

            if (xDest != xFrom && distance == 1 && xDistance == 1 && toPiece.isPresent()) {
                toPiece.get().remove();
                //throw new NotMoveAllowedExecption("Must be same column");
            } else if (xDest != xFrom) {
                throw new NotMoveAllowedExecption();
            }
        }

        firstMove = false;
        setPosition(to);
    }
}
