package dev.jvictor.chess.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RookMovementTest {
    
    Board board;

    @BeforeEach
    public void resetBoard() {
        board = new Board();
        board.moveWithoutValidation("a1d4");
        board.moveWithoutValidation("h1e4");
    }

    @Test
    public void validForwardRookMoveTest() {
        board.move("e4e5");
        org.junit.jupiter.api.Assertions.assertTrue(board.legal);
        org.junit.jupiter.api.Assertions.assertEquals(board.getPieceAt("e5").getSymbol(), "R");
    }

    @Test
    public void validLeftRookMoveTest() {
        board.move("d4c4");
        org.junit.jupiter.api.Assertions.assertTrue(board.legal);
        org.junit.jupiter.api.Assertions.assertEquals(board.getPieceAt("c4").getSymbol(), "R");
    }

    @Test
    public void validBackwardRookMoveTest() {
        board.move("e4e3");
        org.junit.jupiter.api.Assertions.assertTrue(board.legal);
        org.junit.jupiter.api.Assertions.assertEquals(board.getPieceAt("e3").getSymbol(), "R");
    }

    @Test
    public void invalidRookMoveTest() {
        board.move("e4d3");
        org.junit.jupiter.api.Assertions.assertFalse(board.legal);
        org.junit.jupiter.api.Assertions.assertEquals(board.getPieceAt("e4").getSymbol(), "R");
        org.junit.jupiter.api.Assertions.assertNull(board.getPieceAt("d3"));
    }

    @Test
    public void invalidRookMoveToBlockedPlaceTest() {
        board.move("e4d4");
        org.junit.jupiter.api.Assertions.assertFalse(board.legal);
        org.junit.jupiter.api.Assertions.assertEquals(board.getPieceAt("e4").getSymbol(), "R");
        org.junit.jupiter.api.Assertions.assertEquals(board.getPieceAt("d4").getSymbol(), "R");
    }

    @Test
    public void invalidRookJumpOverAllyTest() {
        board.move("e4a4");
        org.junit.jupiter.api.Assertions.assertFalse(board.legal);
        org.junit.jupiter.api.Assertions.assertEquals(board.getPieceAt("e4").getSymbol(), "R");
        org.junit.jupiter.api.Assertions.assertEquals(board.getPieceAt("d4").getSymbol(), "R");
        org.junit.jupiter.api.Assertions.assertNull(board.getPieceAt("a4"));
    }

    @Test
    public void validRookTakesTest() {
        org.junit.jupiter.api.Assertions.assertEquals(board.getPieceAt("e7").getSymbol(), "P");
        board.move("e4e7");
        org.junit.jupiter.api.Assertions.assertTrue(board.legal);
        org.junit.jupiter.api.Assertions.assertEquals(board.getPieceAt("e7").getSymbol(), "R");
    }

    @Test
    public void invalidRookTakesOverOtherPieceTest() {
        board.move("d4d8");
        org.junit.jupiter.api.Assertions.assertFalse(board.legal);
        org.junit.jupiter.api.Assertions.assertEquals(board.getPieceAt("d7").getSymbol(), "P");
        org.junit.jupiter.api.Assertions.assertEquals(board.getPieceAt("d8").getSymbol(), "Q");
        org.junit.jupiter.api.Assertions.assertEquals(board.getPieceAt("d4").getSymbol(), "R");
    }

    @Test
    public void invalidRookTakesTest() {
        board.move("d4g7");
        org.junit.jupiter.api.Assertions.assertFalse(board.legal);
        org.junit.jupiter.api.Assertions.assertEquals(board.getPieceAt("d4").getSymbol(), "R");
        org.junit.jupiter.api.Assertions.assertEquals(board.getPieceAt("g7").getSymbol(), "P");
        org.junit.jupiter.api.Assertions.assertNull(board.getPieceAt("e5"));
        org.junit.jupiter.api.Assertions.assertNull(board.getPieceAt("f6"));
    }
}
