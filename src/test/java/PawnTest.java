package test.java;

import main.java.ChessException;
import main.java.NotMoveAllowedExecption;
import main.java.NotPieceFoundException;
import main.java.chess.Chess;
import main.java.pieces.Piece;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by najorcruzcruz on 27/6/16.
 */
public class PawnTest {

    @Test
    public void moveTest() throws ChessException {
        Chess game = Chess.createGame();

        Piece piece = game.move("white", "A2", "A4");
        Piece pieceBlack = game.move("black", "B7", "B5");

        Assert.assertEquals("A4", piece.getPosition());
        Assert.assertEquals("white", piece.getColor());

        Assert.assertEquals("B5", pieceBlack.getPosition());
        Assert.assertEquals("black", pieceBlack.getColor());
    }

    @Test(expected = NotMoveAllowedExecption.class)
    public void moveFalseTest() throws ChessException {
        Chess game = Chess.createGame();

        game.move("white", "A2", "B4");
    }

    @Test(expected = NotMoveAllowedExecption.class)
    public void moveBackFalseTest() throws NotMoveAllowedExecption, NotPieceFoundException {
        Chess game = Chess.createGame();

        game.move("white", "A2", "A4");
        game.move("white", "A4", "A3");
    }

    @Test(expected = NotPieceFoundException.class)
    public void emptySquareTest() throws NotMoveAllowedExecption, NotPieceFoundException {
        Chess game = Chess.createGame();

        game.move("white", "A3", "A4");
    }

    @Test(expected = NotMoveAllowedExecption.class)
    public void moveToAlreadyOccupiedSquareTest() throws NotPieceFoundException, NotMoveAllowedExecption {
        Chess game = Chess.createGame();

        game.move("white", "A2", "A4");
        game.move("black", "A7", "A5");
        game.move("white", "A4", "A5");
    }

    @Test
    public void removeTest() throws NotPieceFoundException, NotMoveAllowedExecption {
        Chess game = Chess.createGame();

        game.move("white", "A2", "A4");
        Piece removedPiece = game.move("black", "B7", "B5");
        game.move("white", "A4", "B5");

        Assert.assertTrue(removedPiece.isRemoved());
    }
}
