package main.java.exception;

/**
 * Created by najorcruzcruz on 9/5/16.
 */
public class NotMoveAllowedException extends ChessException {

    public NotMoveAllowedException() {
        super("This move is not allowed.");
    }

    public NotMoveAllowedException(String message) {
        super(message);
    }
}
