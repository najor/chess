package test.java;

import main.java.NotMoveAllowedExecption;
import main.java.NotPieceFoundException;
import main.java.chess.Chess;
import main.java.pieces.Piece;
import main.java.pieces.PieceType;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by najorcruzcruz on 8/6/16.
 */
public class RookTest {

    @Test
    public void moveTest() throws NotPieceFoundException, NotMoveAllowedExecption {
        Chess game = Chess.createGame();

        game.move("white", "A2", "A4");
        game.move("black", "B7", "B5");
        game.move("white", "A4", "B5");
        game.move("black", "C7", "C5");

        Piece rook = game.move("white", "A1", "A5");

        Assert.assertEquals(rook.getPosition(), "A5");
        Assert.assertEquals(rook.getType(), PieceType.ROOK);

        game.move("white", "A5", "A3");
        game.move("black", "G7", "G6");
        game.move("white", "A3", "H3");
    }

    @Test(expected = NotMoveAllowedExecption.class)
    public void diagonalMoveTest() throws NotPieceFoundException, NotMoveAllowedExecption {
        Chess game = Chess.createGame();
        game.move("white", "A1", "B5");
    }

    @Test(expected = NotMoveAllowedExecption.class)
    public void pieceInMiddleOfTrajectoryRowTest() throws NotPieceFoundException, NotMoveAllowedExecption {
        Chess game = Chess.createGame();
        game.move("white", "A1", "A5");
    }

    @Test(expected = NotMoveAllowedExecption.class)
    public void pieceInMiddleOfTrajectoryColumnTest() throws NotPieceFoundException, NotMoveAllowedExecption {
        Chess game = Chess.createGame();

        game.move("white", "A2", "A4");
        game.move("black", "B7", "B5");
        game.move("white", "A4", "B5");
        game.move("black", "C7", "C5");
        game.move("white", "A1", "A5");
        game.move("black", "D7", "D5");
        game.move("white", "A5", "F5");
    }
}
