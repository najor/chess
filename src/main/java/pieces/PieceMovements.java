package main.java.pieces;

import main.java.NotMoveAllowedExecption;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by najorcruzcruz on 31/5/16.
 */
public class PieceMovements {
    private String from;
    private String to;
    private int columnTo;
    private int rowTo;
    private int columnFrom;
    private int rowFrom;

    public PieceMovements(String from, String to) {
        this.to = to;
        this.from = from;
    }

    public int getColumnTo() {
        return columnTo;
    }

    public int getRowTo() {
        return rowTo;
    }

    public int getColumnFrom() {
        return columnFrom;
    }

    public int getRowFrom() {
        return rowFrom;
    }

    public PieceMovements invoke() throws NotMoveAllowedExecption {
        Pattern patternPosition = Pattern.compile("(\\w)(\\d)");
        Matcher matcherPosition = patternPosition.matcher(to);

        if (!matcherPosition.matches()) {
            throw new NotMoveAllowedExecption("Destiny is not well constructed");
        }

        columnTo = Character.getNumericValue(matcherPosition.group(1).charAt(0));
        rowTo = Integer.parseInt(matcherPosition.group(2));

        if (!matcherPosition.matches()) {
            throw new NotMoveAllowedExecption();
        }

        matcherPosition = patternPosition.matcher(from);

        if (!matcherPosition.matches()) {
            throw new NotMoveAllowedExecption();
        }

        columnFrom = Character.getNumericValue(matcherPosition.group(1).charAt(0));
        rowFrom = Integer.parseInt(matcherPosition.group(2));

        return this;
    }
}
