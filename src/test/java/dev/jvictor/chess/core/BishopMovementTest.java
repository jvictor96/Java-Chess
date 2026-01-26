package dev.jvictor.chess.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BishopMovementTest {
    
    Board board;

    @BeforeEach
    public void resetBoard() {
        board = new Board();
        board = board.moveWithoutValidation("c1e4");
        board = board.moveWithoutValidation("f1d4");
        board = board.moveWithoutValidation("h1h2");
        board = board.moveWithoutValidation("a8a7");
    }

    @Test
    public void validForwardLeftBishopMoveTest() {
        board.move("e4d5");
        org.junit.jupiter.api.Assertions.assertTrue(board.legal);
        org.junit.jupiter.api.Assertions.assertEquals(board.getPieceAt("d5").getSymbol(), "B");
    }

    @Test
    public void validBackwardLeftBishopMoveTest() {
        board.move("e4d3");
        org.junit.jupiter.api.Assertions.assertTrue(board.legal);
        org.junit.jupiter.api.Assertions.assertEquals(board.getPieceAt("d3").getSymbol(), "B");
    }

    @Test
    public void validBackwardRightBishopMoveTest() {
        board.move("e4f3");
        org.junit.jupiter.api.Assertions.assertTrue(board.legal);
        org.junit.jupiter.api.Assertions.assertEquals(board.getPieceAt("f3").getSymbol(), "B");
    }

    @Test
    public void invalidBishopMoveTest() {
        board.move("e4e3");
        org.junit.jupiter.api.Assertions.assertFalse(board.legal);
        org.junit.jupiter.api.Assertions.assertEquals(board.getPieceAt("e4").getSymbol(), "B");
        org.junit.jupiter.api.Assertions.assertNull(board.getPieceAt("e3"));
    }

    @Test
    public void invalidBishopMoveToBlockedPlaceTest() {
        board.move("e4c2");
        org.junit.jupiter.api.Assertions.assertFalse(board.legal);
        org.junit.jupiter.api.Assertions.assertEquals(board.getPieceAt("e4").getSymbol(), "B");
        org.junit.jupiter.api.Assertions.assertEquals(board.getPieceAt("c2").getSymbol(), "P");
    }

    @Test
    public void invalidBishopJumpOverAllyTest() {
        board.move("e4h1");
        org.junit.jupiter.api.Assertions.assertFalse(board.legal);
        org.junit.jupiter.api.Assertions.assertEquals(board.getPieceAt("e4").getSymbol(), "B");
        org.junit.jupiter.api.Assertions.assertEquals(board.getPieceAt("g2").getSymbol(), "P");
        org.junit.jupiter.api.Assertions.assertNull(board.getPieceAt("h1"));
    }

    @Test
    public void invalidBishopJumpOverOpponentTest() {
        board.move("e4a8");
        org.junit.jupiter.api.Assertions.assertFalse(board.legal);
        org.junit.jupiter.api.Assertions.assertEquals(board.getPieceAt("e4").getSymbol(), "B");
        org.junit.jupiter.api.Assertions.assertEquals(board.getPieceAt("b7").getSymbol(), "P");
        org.junit.jupiter.api.Assertions.assertNull(board.getPieceAt("a8"));
    }

    @Test
    public void validBishopTakesTest() {
        org.junit.jupiter.api.Assertions.assertEquals(board.getPieceAt("h7").getSymbol(), "P");
        board.move("e4h7");
        org.junit.jupiter.api.Assertions.assertTrue(board.legal);
        org.junit.jupiter.api.Assertions.assertEquals(board.getPieceAt("h7").getSymbol(), "B");
    }

    @Test
    public void invalidBishopTakesOverOtherPieceTest() {
        board.move("d4h8");
        org.junit.jupiter.api.Assertions.assertFalse(board.legal);
        org.junit.jupiter.api.Assertions.assertEquals(board.getPieceAt("g7").getSymbol(), "P");
        org.junit.jupiter.api.Assertions.assertEquals(board.getPieceAt("h8").getSymbol(), "R");
        org.junit.jupiter.api.Assertions.assertEquals(board.getPieceAt("d4").getSymbol(), "B");
    }

    @Test
    public void invalidBishopTakesTest() {
        board.move("d4d7");
        org.junit.jupiter.api.Assertions.assertFalse(board.legal);
        org.junit.jupiter.api.Assertions.assertEquals(board.getPieceAt("d4").getSymbol(), "B");
        org.junit.jupiter.api.Assertions.assertEquals(board.getPieceAt("d7").getSymbol(), "P");
        org.junit.jupiter.api.Assertions.assertNull(board.getPieceAt("d5"));
        org.junit.jupiter.api.Assertions.assertNull(board.getPieceAt("d6"));
    }
}
