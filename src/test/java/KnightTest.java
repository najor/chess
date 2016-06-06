package test.java;


import main.java.ChessException;
import main.java.NotMoveAllowedExecption;
import main.java.NotPieceFoundException;
import main.java.chess.Chess;
import main.java.pieces.Piece;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by najorcruzcruz on 11/4/16.
 */
public class KnightTest {

    @Test
    public void moveTest() throws NotPieceFoundException, NotMoveAllowedExecption {
        Chess game = Chess.createGame();

        Piece piece = game.move("white", "B1", "C3");

        Assert.assertEquals("C3", piece.getPosition());
        Assert.assertEquals("white", piece.getColor());

        Piece pieceBlack = game.move("black", "B8", "A6");

        Assert.assertEquals("A6", pieceBlack.getPosition());
        Assert.assertEquals("black", pieceBlack.getColor());

        piece = game.move("white", "C3", "B1");

        Assert.assertEquals("B1", piece.getPosition());
        Assert.assertEquals("white", piece.getColor());
    }

    @Test(expected = NotMoveAllowedExecption.class)
    public void moveFalseTest() throws ChessException {
        Chess game = Chess.createGame();

        game.move("white", "B1", "A4");
    }

    @Test
    public void removeTest() throws NotPieceFoundException, NotMoveAllowedExecption {

        Chess game = Chess.createGame();

        game.move("white", "B1", "C3");
        Piece pieceBlack = game.move("black", "B7", "B5");
        Piece piece = game.move("white", "C3", "B5");

        Assert.assertTrue(pieceBlack.isRemoved());


    }
}
