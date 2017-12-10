package test.java.chess;


import org.junit.Assert;
import org.junit.Test;

import main.java.chess.Chess;
import main.java.chess.Player;
import main.java.exception.NotMoveAllowedException;
import main.java.exception.NotPieceFoundException;

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

    @Test(expected = NotMoveAllowedException.class)
    public void moveSamePositionTest() throws NotPieceFoundException, NotMoveAllowedException {
        Chess game = Chess.createGame();
        game.move("white", "E2", "E2");
    }

    @Test
    public void moveCaseInsensitive() throws NotPieceFoundException, NotMoveAllowedException {
        Chess game = Chess.createGame();
        game.move("white", "e2", "e3");
    }
}
