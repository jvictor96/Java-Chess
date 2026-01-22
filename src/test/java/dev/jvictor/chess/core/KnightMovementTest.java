package dev.jvictor.chess.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class KnightMovementTest {
    
    Board board;

    @BeforeEach
    public void resetBoard() {
        board = new Board();
    }

    @Test
    public void validForwardRightKnightMoveTest() {
        board.move("c3d5");
        org.junit.jupiter.api.Assertions.assertTrue(board.legal);
        org.junit.jupiter.api.Assertions.assertEquals(board.positions.get("d5").getSymbol(), "N");
    }

    @Test
    public void validRightForwardKnightMoveTest() {
        board.move("c3e4");
        org.junit.jupiter.api.Assertions.assertTrue(board.legal);
        org.junit.jupiter.api.Assertions.assertEquals(board.positions.get("e4").getSymbol(), "N");
    }

    @Test
    public void validForwardLeftKnightMoveTest() {
        board.move("c3b5");
        org.junit.jupiter.api.Assertions.assertTrue(board.legal);
        org.junit.jupiter.api.Assertions.assertEquals(board.positions.get("b5").getSymbol(), "N");
    }

    @Test
    public void validLeftForwardKnightMoveTest() {
        board.move("c3a4");
        org.junit.jupiter.api.Assertions.assertTrue(board.legal);
        org.junit.jupiter.api.Assertions.assertEquals(board.positions.get("a4").getSymbol(), "N");
    }

    @Test
    public void validBackwardKnightMoveTest() {
        board.move("c3b1");
        org.junit.jupiter.api.Assertions.assertTrue(board.legal);
        org.junit.jupiter.api.Assertions.assertEquals(board.positions.get("b1").getSymbol(), "N");
    }

    @Test
    public void invalidForwardKnightMoveTest() {
        board.move("c3c5");
        org.junit.jupiter.api.Assertions.assertFalse(board.legal);
        org.junit.jupiter.api.Assertions.assertEquals(board.positions.get("c3").getSymbol(), "N");
        org.junit.jupiter.api.Assertions.assertNull(board.positions.get("c5"));
    }

    @Test
    public void invalidRightKnightMoveTest() {
        board.move("c3e3");
        org.junit.jupiter.api.Assertions.assertFalse(board.legal);
        org.junit.jupiter.api.Assertions.assertEquals(board.positions.get("c3").getSymbol(), "N");
        org.junit.jupiter.api.Assertions.assertNull(board.positions.get("e3"));
    }

    @Test
    public void invalidKnightMoveToBlockedPlaceTest() {
        board.move("c3e2");
        org.junit.jupiter.api.Assertions.assertFalse(board.legal);
        org.junit.jupiter.api.Assertions.assertEquals(board.positions.get("c3").getSymbol(), "N");
        org.junit.jupiter.api.Assertions.assertEquals(board.positions.get("e2").getSymbol(), "P");
    }

    @Test
    public void invalidKnightTakesTest() {
        board.move("c3c7");
        org.junit.jupiter.api.Assertions.assertFalse(board.legal);
        org.junit.jupiter.api.Assertions.assertEquals(board.positions.get("c3").getSymbol(), "N");
        org.junit.jupiter.api.Assertions.assertEquals(board.positions.get("c7").getSymbol(), "P");
    }
    
}
