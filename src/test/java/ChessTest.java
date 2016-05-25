package test.java;


import main.java.NotMoveAllowedExecption;
import main.java.chess.Chess;
import main.java.chess.Player;
import main.java.pieces.Piece;
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

    @Test
    public void moveTest() throws NotMoveAllowedExecption {
        Chess game = Chess.createGame();

        Piece piece = game.move("white", "A2", "A4");

        Assert.assertEquals("A4", piece.getPosition());
        Assert.assertEquals("white", piece.getColor());
    }

    @Test(expected = NotMoveAllowedExecption.class)
    public void moveFalseTest() throws NotMoveAllowedExecption {
        Chess game = Chess.createGame();

        Piece piece = game.move("white", "A2", "B4");
    }

    @Test(expected = NotMoveAllowedExecption.class)
    public void moveBackFalseTest() throws NotMoveAllowedExecption {
        Chess game = Chess.createGame();

        game.move("white", "A2", "A4");
        game.move("white", "A4", "A3");
    }
}
