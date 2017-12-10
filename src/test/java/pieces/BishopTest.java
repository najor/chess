package test.java.pieces;

import org.junit.Assert;
import org.junit.Test;

import main.java.chess.Chess;
import main.java.exception.NotMoveAllowedException;
import main.java.exception.NotPieceFoundException;
import main.java.pieces.Piece;

/**
 * Created by najorcruzcruz on 28/7/16.
 */
public class BishopTest {

    @Test
    public void moveTest() throws NotPieceFoundException, NotMoveAllowedException {
        Chess game = Chess.createGame();

        game.move("white", "D2", "D4");
        game.move("black", "D7", "D5");

        Piece bishop = game.move("white", "C1", "G5");

        Assert.assertEquals(bishop.getPosition(), "G5");
    }

    @Test(expected = NotMoveAllowedException.class)
    public void wrongMove() throws NotPieceFoundException, NotMoveAllowedException {
        Chess game = Chess.createGame();

        game.move("white", "D2", "D4");
        game.move("black", "H7", "H6");
        game.move("white", "C1", "C3");
    }

    @Test(expected = NotMoveAllowedException.class)
    public void pieceInTheMiddleRightTopTest() throws NotPieceFoundException, NotMoveAllowedException {
        Chess game = Chess.createGame();

        game.move("white", "C1", "G5");
    }

    @Test(expected = NotMoveAllowedException.class)
    public void pieceInTheMiddleRightDownTest() throws NotPieceFoundException, NotMoveAllowedException {
        Chess game = Chess.createGame();

        game.move("white", "D2", "D4");
        game.move("black", "H7", "H6");
        game.move("white", "C1", "E3");
        game.move("black", "G7", "G5");
        game.move("white", "E3", "G1");
    }

    @Test(expected = NotMoveAllowedException.class)
    public void pieceInTheMiddleLeftDownTest() throws NotPieceFoundException, NotMoveAllowedException {
        Chess game = Chess.createGame();

        game.move("white", "D2", "D4");
        game.move("black", "H7", "H6");
        game.move("white", "C1", "H6");
        game.move("black", "G7", "G5");
        game.move("white", "H6", "C1");
    }

    @Test(expected = NotMoveAllowedException.class)
    public void pieceInTheMiddleLeftTopTest() throws NotPieceFoundException, NotMoveAllowedException {
        Chess game = Chess.createGame();

        game.move("white", "D2", "D4");
        game.move("black", "H7", "H6");
        game.move("white", "C1", "F4");
        game.move("black", "G7", "G5");
        game.move("white", "F4", "B8");
    }

    @Test
    public void attackPawnTest() throws NotPieceFoundException, NotMoveAllowedException {
        Chess game = Chess.createGame();

        game.move("white", "D2", "D4");
        Piece pawn = game.move("black", "H7", "H6");

        Piece bishop = game.move("white", "C1", "H6");

        Assert.assertEquals(bishop.getPosition(), "H6");
        Assert.assertTrue(pawn.isRemoved());
    }
}
