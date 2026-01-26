package dev.jvictor.chess.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class KingMovementTest {
    
    Board board;

    @BeforeEach
    public void resetBoard() {
        board = new Board();
        board.moveWithoutValidation(board.buildMovement("e1e4"));
        board.moveWithoutValidation(board.buildMovement("a2f3"));
        board.moveWithoutValidation(board.buildMovement("b7f5"));
    }

    @Test
    public void validForwardLeftKingMoveTest() {
        board.move(board.buildMovement("e4d5"));
        org.junit.jupiter.api.Assertions.assertTrue(board.legal);
        org.junit.jupiter.api.Assertions.assertEquals(board.getPieceAt("d5").getSymbol(), "K");
    }

    @Test
    public void validBackwardLeftKingMoveTest() {
        board.move(board.buildMovement("e4d3"));
        org.junit.jupiter.api.Assertions.assertTrue(board.legal);
        org.junit.jupiter.api.Assertions.assertEquals(board.getPieceAt("d3").getSymbol(), "K");
    }

    @Test
    public void validBackwardKingMoveTest() {
        board.move(board.buildMovement("e4e3"));
        org.junit.jupiter.api.Assertions.assertTrue(board.legal);
        org.junit.jupiter.api.Assertions.assertEquals(board.getPieceAt("e3").getSymbol(), "K");
    }

    @Test
    public void validRightKingMoveTest() {
        board.move(board.buildMovement("e4f4"));
        org.junit.jupiter.api.Assertions.assertTrue(board.legal);
        org.junit.jupiter.api.Assertions.assertEquals(board.getPieceAt("f4").getSymbol(), "K");
    }

    @Test
    public void invalidKingMoveTest() {
        board.move(board.buildMovement("e4g4"));
        org.junit.jupiter.api.Assertions.assertFalse(board.legal);
        org.junit.jupiter.api.Assertions.assertEquals(board.getPieceAt("e4").getSymbol(), "K");
        org.junit.jupiter.api.Assertions.assertNull(board.getPieceAt("g4"));
    }

    @Test
    public void invalidKingMoveToBlockedPlaceTest() {
        board.move(board.buildMovement("e4f3"));
        org.junit.jupiter.api.Assertions.assertFalse(board.legal);
        org.junit.jupiter.api.Assertions.assertEquals(board.getPieceAt("e4").getSymbol(), "K");
        org.junit.jupiter.api.Assertions.assertEquals(board.getPieceAt("f3").getSymbol(), "P");
    }

    @Test
    public void validKingTakesTest() {
        org.junit.jupiter.api.Assertions.assertEquals(board.getPieceAt("f5").getSymbol(), "P");
        board.move(board.buildMovement("e4f5"));
        org.junit.jupiter.api.Assertions.assertTrue(board.legal);
        org.junit.jupiter.api.Assertions.assertEquals(board.getPieceAt("f5").getSymbol(), "K");
    }

    @Test
    public void invalidKingTakesTest() {
        board.move(board.buildMovement("e4e7"));
        org.junit.jupiter.api.Assertions.assertFalse(board.legal);
        org.junit.jupiter.api.Assertions.assertEquals(board.getPieceAt("e4").getSymbol(), "K");
        org.junit.jupiter.api.Assertions.assertEquals(board.getPieceAt("e7").getSymbol(), "P");
        org.junit.jupiter.api.Assertions.assertNull(board.getPieceAt("e5"));
        org.junit.jupiter.api.Assertions.assertNull(board.getPieceAt("e6"));
    }
    
}
