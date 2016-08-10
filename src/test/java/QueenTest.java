package test.java;

import main.java.ChessException;
import main.java.NotMoveAllowedExecption;
import main.java.NotPieceFoundException;
import main.java.chess.Chess;
import main.java.pieces.Piece;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by najorcruzcruz on 10/8/16.
 */
public class QueenTest {

    @Test
    public void moveTest() throws NotPieceFoundException, NotMoveAllowedExecption {
        Chess game = Chess.createGame();

        game.move("white", "E2", "E3");
        Piece queen = game.move("white", "D1", "G4");

        Assert.assertEquals("G4", queen.getPosition());
    }

    @Test(expected = NotMoveAllowedExecption.class)
    public void moveFalseTest() throws ChessException {
        Chess game = Chess.createGame();

        game.move("white", "D1", "C4");
    }

    @Test(expected = NotMoveAllowedExecption.class)
    public void movePieceInTheMiddleDiagonalTest() throws ChessException {
        Chess game = Chess.createGame();

        game.move("white", "D1", "G4");
    }

    @Test(expected = NotMoveAllowedExecption.class)
    public void movePieceInTheMiddleVerticalTest() throws ChessException {
        Chess game = Chess.createGame();

        game.move("white", "D1", "D4");
    }

    @Test(expected = NotMoveAllowedExecption.class)
    public void movePieceInTheMiddleHorizontalTest() throws ChessException {
        Chess game = Chess.createGame();

        game.move("white", "D1", "A1");
    }
}
