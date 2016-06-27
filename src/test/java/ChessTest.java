package test.java;


import main.java.NotMoveAllowedExecption;
import main.java.NotPieceFoundException;
import main.java.chess.Chess;
import main.java.chess.Player;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by najorcruzcruz on 11/4/16.
 */
public class ChessTest {

    @Test
    public void checkInitGameTest() {
        Chess game = Chess.createGame();

        Player playerWhite = game.getPlayerWhite();
        Player playerBlack = game.getPlayerBlack();

        Assert.assertEquals(playerWhite.getPieces().size(), 16);
        Assert.assertEquals(playerBlack.getPieces().size(), 16);

    }

    @Test(expected = NotMoveAllowedExecption.class)
    public void moveSamePositionTest() throws NotPieceFoundException, NotMoveAllowedExecption {
        Chess game = Chess.createGame();
        game.move("white", "E2", "E2");
    }
}
