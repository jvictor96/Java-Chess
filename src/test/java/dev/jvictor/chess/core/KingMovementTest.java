package dev.jvictor.chess.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class KingMovementTest {
    
    Board board;

    @BeforeEach
    public void resetBoard() {
        board = new Board();
        board.moveWithoutValidation("e1e4");
        board.moveWithoutValidation("a2f3");
        board.moveWithoutValidation("b7f5");
    }

    @Test
    public void validForwardLeftKingMoveTest() {
        board.move("e4d5");
        org.junit.jupiter.api.Assertions.assertTrue(board.legal);
        org.junit.jupiter.api.Assertions.assertEquals(board.getPieceAt("d5").getSymbol(), "K");
    }

    @Test
    public void validBackwardLeftKingMoveTest() {
        board.move("e4d3");
        org.junit.jupiter.api.Assertions.assertTrue(board.legal);
        org.junit.jupiter.api.Assertions.assertEquals(board.getPieceAt("d3").getSymbol(), "K");
    }

    @Test
    public void validBackwardKingMoveTest() {
        board.move("e4e3");
        org.junit.jupiter.api.Assertions.assertTrue(board.legal);
        org.junit.jupiter.api.Assertions.assertEquals(board.getPieceAt("e3").getSymbol(), "K");
    }

    @Test
    public void validRightKingMoveTest() {
        board.move("e4f4");
        org.junit.jupiter.api.Assertions.assertTrue(board.legal);
        org.junit.jupiter.api.Assertions.assertEquals(board.getPieceAt("f4").getSymbol(), "K");
    }

    @Test
    public void invalidKingMoveTest() {
        board.move("e4g4");
        org.junit.jupiter.api.Assertions.assertFalse(board.legal);
        org.junit.jupiter.api.Assertions.assertEquals(board.getPieceAt("e4").getSymbol(), "K");
        org.junit.jupiter.api.Assertions.assertNull(board.getPieceAt("g4"));
    }

    @Test
    public void invalidKingMoveToBlockedPlaceTest() {
        board.move("e4f3");
        org.junit.jupiter.api.Assertions.assertFalse(board.legal);
        org.junit.jupiter.api.Assertions.assertEquals(board.getPieceAt("e4").getSymbol(), "K");
        org.junit.jupiter.api.Assertions.assertEquals(board.getPieceAt("f3").getSymbol(), "P");
    }

    @Test
    public void validKingTakesTest() {
        org.junit.jupiter.api.Assertions.assertEquals(board.getPieceAt("f5").getSymbol(), "P");
        board.move("e4f5");
        org.junit.jupiter.api.Assertions.assertTrue(board.legal);
        org.junit.jupiter.api.Assertions.assertEquals(board.getPieceAt("f5").getSymbol(), "K");
    }

    @Test
    public void invalidKingTakesTest() {
        board.move("e4e7");
        org.junit.jupiter.api.Assertions.assertFalse(board.legal);
        org.junit.jupiter.api.Assertions.assertEquals(board.getPieceAt("e4").getSymbol(), "K");
        org.junit.jupiter.api.Assertions.assertEquals(board.getPieceAt("e7").getSymbol(), "P");
        org.junit.jupiter.api.Assertions.assertNull(board.getPieceAt("e5"));
        org.junit.jupiter.api.Assertions.assertNull(board.getPieceAt("e6"));
    }
    
}
