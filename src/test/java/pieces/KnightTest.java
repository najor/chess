package test.java.pieces;


import main.java.exception.ChessException;
import main.java.exception.NotMoveAllowedException;
import main.java.exception.NotPieceFoundException;
import main.java.chess.Chess;
import main.java.pieces.Piece;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by najorcruzcruz on 11/4/16.
 */
public class KnightTest {

    @Test
    public void moveTest() throws NotPieceFoundException, NotMoveAllowedException {
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

    @Test(expected = NotMoveAllowedException.class)
    public void moveFalseTest() throws ChessException {
        Chess game = Chess.createGame();

        game.move("white", "B1", "A4");
    }

    @Test
    public void removeTest() throws NotPieceFoundException, NotMoveAllowedException {
        Chess game = Chess.createGame();

        game.move("white", "B1", "C3");
        Piece pieceBlack = game.move("black", "B7", "B5");
        game.move("white", "C3", "B5");

        Assert.assertTrue(pieceBlack.isRemoved());
    }

    @Test(expected = NotMoveAllowedException.class)
    public void badMoveToSameColorPieceTest() throws NotPieceFoundException, NotMoveAllowedException {
        Chess game = Chess.createGame();

        game.move("white", "B1", "D2");
    }

    @Test(expected = NotMoveAllowedException.class)
    public void moveToWhitePosition() throws NotPieceFoundException, NotMoveAllowedException {
        Chess game = Chess.createGame();

        game.move("white", "B1", "C3");
        game.move("black", "B7", "B5");

        game.move("white", "C3", "B5");
        game.move("black", "A7", "A5");

        game.move("white", "B5", "D4");
        game.move("black", "E7", "E5");

        game.move("white", "G1", "F3");
        game.move("black", "H7", "H5");

        game.move("white", "F3", "D4");

    }
}
