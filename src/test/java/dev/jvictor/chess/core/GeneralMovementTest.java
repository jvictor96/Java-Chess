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
        org.junit.jupiter.api.Assertions.assertEquals(board.getPieceAt("a2").getSymbol(), "P");
        board.move(board.buildMovement("a2a3"));
        org.junit.jupiter.api.Assertions.assertTrue(board.legal);
        org.junit.jupiter.api.Assertions.assertEquals(board.getPieceAt("a3").getSymbol(), "P");
        org.junit.jupiter.api.Assertions.assertNull(board.getPieceAt("a2"));
        board.move(board.buildMovement("a3a4"));
        org.junit.jupiter.api.Assertions.assertFalse(board.legal);
        org.junit.jupiter.api.Assertions.assertEquals(board.getPieceAt("a3").getSymbol(), "P");
        org.junit.jupiter.api.Assertions.assertNull(board.getPieceAt("a4"));
    }

    @Test
    public void invalidRookToOutsideTheBoardTest() {
        board.move(board.buildMovement("h1i1"));
        org.junit.jupiter.api.Assertions.assertFalse(board.legal);
        org.junit.jupiter.api.Assertions.assertEquals(board.getPieceAt("h1").getSymbol(), "R");
        board.move(board.buildMovement("h1h0"));
        org.junit.jupiter.api.Assertions.assertFalse(board.legal);
        org.junit.jupiter.api.Assertions.assertEquals(board.getPieceAt("h1").getSymbol(), "R");
    }

    @Test
    public void moveToOriginTest() {
        board.move(board.buildMovement("a2a2"));
        org.junit.jupiter.api.Assertions.assertFalse(board.legal);
        org.junit.jupiter.api.Assertions.assertEquals(board.getPieceAt("a2").getSymbol(), "P");
    }

    @Test
    public void blackMoveFirstTest() {
        board.move(board.buildMovement("e7e6"));
        org.junit.jupiter.api.Assertions.assertFalse(board.legal);
        org.junit.jupiter.api.Assertions.assertEquals(board.getPieceAt("e7").getSymbol(), "P");
        org.junit.jupiter.api.Assertions.assertNull(board.getPieceAt("e6"));
    }

    @Test
    public void invalidMovePlaysAgainTest() {
        board.move(board.buildMovement("a2a2"));
        org.junit.jupiter.api.Assertions.assertFalse(board.legal);
        board.move(board.buildMovement("a2a3"));
        org.junit.jupiter.api.Assertions.assertTrue(board.legal);
    }
}
