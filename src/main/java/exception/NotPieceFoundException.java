package main.java.exception;

/**
 * Created by najorcruzcruz on 9/5/16.
 */
public class NotPieceFoundException extends ChessException {

    public NotPieceFoundException() {
        super("There is not a piece in this position.");
    }

}
