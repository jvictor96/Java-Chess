package dev.jvictor.chess.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GeneralMovementTest {
    
    Board board;

    @BeforeEach
    public void resetBoard() {
        board = new Board();
    }

    @Test
    public void invalidWhiteMovesTwiceTest() {
        org.junit.jupiter.api.Assertions.assertEquals(board.positions.get("a2").getSymbol(), "P");
        board.move("a2a3");
        org.junit.jupiter.api.Assertions.assertTrue(board.legal);
        org.junit.jupiter.api.Assertions.assertEquals(board.positions.get("a3").getSymbol(), "P");
        org.junit.jupiter.api.Assertions.assertNull(board.positions.get("a2"));
        board.move("a3a4");
        org.junit.jupiter.api.Assertions.assertFalse(board.legal);
        org.junit.jupiter.api.Assertions.assertEquals(board.positions.get("a3").getSymbol(), "P");
        org.junit.jupiter.api.Assertions.assertNull(board.positions.get("a4"));
    }

    @Test
    public void invalidRookToOutsideTheBoardTest() {
        board.move("h1i1");
        org.junit.jupiter.api.Assertions.assertFalse(board.legal);
        org.junit.jupiter.api.Assertions.assertEquals(board.positions.get("h1").getSymbol(), "R");
        board.move("h1h0");
        org.junit.jupiter.api.Assertions.assertFalse(board.legal);
        org.junit.jupiter.api.Assertions.assertEquals(board.positions.get("h1").getSymbol(), "R");
    }

    @Test
    public void moveToOriginTest() {
        board.move("a2a2");
        org.junit.jupiter.api.Assertions.assertFalse(board.legal);
        org.junit.jupiter.api.Assertions.assertEquals(board.positions.get("a2").getSymbol(), "P");
    }

    @Test
    public void blackMoveFirstTest() {
        board.move("e7e6");
        org.junit.jupiter.api.Assertions.assertFalse(board.legal);
        org.junit.jupiter.api.Assertions.assertEquals(board.positions.get("e7").getSymbol(), "P");
        org.junit.jupiter.api.Assertions.assertNull(board.positions.get("e6"));
    }

    @Test
    public void invalidMovePlaysAgainTest() {
        board.move("a2a2");
        org.junit.jupiter.api.Assertions.assertFalse(board.legal);
        board.move("a2a3");
        org.junit.jupiter.api.Assertions.assertTrue(board.legal);
    }
}
