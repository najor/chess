package main.java.pieces;

import main.java.NotMoveAllowedExecption;

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
    public void move(String to) throws NotMoveAllowedExecption {
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

            if (xDest != xFrom) {
                throw new NotMoveAllowedExecption("Must be same column");
            }

            int distance = numDest - numFrom;
            if ((!firstMove && distance > 1) || (firstMove && distance > 2) || distance <= 0) {
                throw new NotMoveAllowedExecption("Too much distance");
            }
        }

        firstMove = false;
        setPosition(to);
    }
}
