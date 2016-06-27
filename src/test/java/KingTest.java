package test.java;

import main.java.NotMoveAllowedExecption;
import main.java.NotPieceFoundException;
import main.java.chess.Chess;
import main.java.pieces.Piece;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by najorcruzcruz on 27/6/16.
 */
public class KingTest {

    @Test
    public void moveTest() throws NotPieceFoundException, NotMoveAllowedExecption {
        Chess game = Chess.createGame();
        game.move("white", "E2", "E4");
        game.move("black", "E7", "E5");

        Piece king = game.move("white", "E1", "E2");

        Assert.assertEquals(king.getPosition(), "E2");
    }

    @Test(expected = NotMoveAllowedExecption.class)
    public void moveFalseTest() throws NotPieceFoundException, NotMoveAllowedExecption {
        Chess game = Chess.createGame();
        game.move("white", "E2", "E4");
        game.move("black", "E7", "E5");

        game.move("white", "E1", "E3");
    }
}
