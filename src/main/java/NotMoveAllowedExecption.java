package main.java;

/**
 * Created by najorcruzcruz on 9/5/16.
 */
public class NotMoveAllowedExecption extends ChessException {

    public NotMoveAllowedExecption() {
        super(" This move is not allowed.");
    }

    public NotMoveAllowedExecption(String message) {
        super(message);
    }
}
