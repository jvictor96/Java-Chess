package dev.jvictor.chess.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class KnightMovementTest {
    
    Board board;

    @BeforeEach
    public void resetBoard() {
        board = new Board();
        board.moveWithoutValidation(board.buildMovement("b1c3"));
    }

    @Test
    public void validForwardRightKnightMoveTest() {
        board.move(board.buildMovement("c3d5"));
        org.junit.jupiter.api.Assertions.assertTrue(board.legal);
        org.junit.jupiter.api.Assertions.assertEquals(board.getPieceAt("d5").getSymbol(), "N");
    }

    @Test
    public void validRightForwardKnightMoveTest() {
        board.move(board.buildMovement("c3e4"));
        org.junit.jupiter.api.Assertions.assertTrue(board.legal);
        org.junit.jupiter.api.Assertions.assertEquals(board.getPieceAt("e4").getSymbol(), "N");
    }

    @Test
    public void validForwardLeftKnightMoveTest() {
        board.move(board.buildMovement("c3b5"));
        org.junit.jupiter.api.Assertions.assertTrue(board.legal);
        org.junit.jupiter.api.Assertions.assertEquals(board.getPieceAt("b5").getSymbol(), "N");
    }

    @Test
    public void validLeftForwardKnightMoveTest() {
        board.move(board.buildMovement("c3a4"));
        org.junit.jupiter.api.Assertions.assertTrue(board.legal);
        org.junit.jupiter.api.Assertions.assertEquals(board.getPieceAt("a4").getSymbol(), "N");
    }

    @Test
    public void validBackwardKnightMoveTest() {
        board.move(board.buildMovement("c3b1"));
        org.junit.jupiter.api.Assertions.assertTrue(board.legal);
        org.junit.jupiter.api.Assertions.assertEquals(board.getPieceAt("b1").getSymbol(), "N");
    }

    @Test
    public void invalidForwardKnightMoveTest() {
        board.move(board.buildMovement("c3c5"));
        org.junit.jupiter.api.Assertions.assertFalse(board.legal);
        org.junit.jupiter.api.Assertions.assertEquals(board.getPieceAt("c3").getSymbol(), "N");
        org.junit.jupiter.api.Assertions.assertNull(board.getPieceAt("c5"));
    }

    @Test
    public void invalidRightKnightMoveTest() {
        board.move(board.buildMovement("c3e3"));
        org.junit.jupiter.api.Assertions.assertFalse(board.legal);
        org.junit.jupiter.api.Assertions.assertEquals(board.getPieceAt("c3").getSymbol(), "N");
        org.junit.jupiter.api.Assertions.assertNull(board.getPieceAt("e3"));
    }

    @Test
    public void invalidKnightMoveToBlockedPlaceTest() {
        board.move(board.buildMovement("c3e2"));
        org.junit.jupiter.api.Assertions.assertFalse(board.legal);
        org.junit.jupiter.api.Assertions.assertEquals(board.getPieceAt("c3").getSymbol(), "N");
        org.junit.jupiter.api.Assertions.assertEquals(board.getPieceAt("e2").getSymbol(), "P");
    }

    @Test
    public void invalidKnightTakesTest() {
        board.move(board.buildMovement("c3c7"));
        org.junit.jupiter.api.Assertions.assertFalse(board.legal);
        org.junit.jupiter.api.Assertions.assertEquals(board.getPieceAt("c3").getSymbol(), "N");
        org.junit.jupiter.api.Assertions.assertEquals(board.getPieceAt("c7").getSymbol(), "P");
    }
    
}
