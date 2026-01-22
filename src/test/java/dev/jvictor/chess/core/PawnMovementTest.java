package dev.jvictor.chess.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PawnMovementTest {
    
    Board board;

    @BeforeEach
    public void resetBoard() {
        board = new Board();
    }

    @Test
    public void validForwardPawnMoveTest() {
        board.move("c2c3");
        org.junit.jupiter.api.Assertions.assertTrue(board.legal);
        org.junit.jupiter.api.Assertions.assertEquals(board.positions.get("c3").getSymbol(), "P");
    }

    @Test
    public void validForwardPawnDoubleMoveTest() {
        board.move("c2c4");
        org.junit.jupiter.api.Assertions.assertTrue(board.legal);
        org.junit.jupiter.api.Assertions.assertEquals(board.positions.get("c4").getSymbol(), "P");
    }

    @Test
    public void invalidForwardPawnDoubleMoveTest() {
        board.move("c2c3");
        board.move("a7a6");
        board.move("c3c5");
        org.junit.jupiter.api.Assertions.assertFalse(board.legal);
        org.junit.jupiter.api.Assertions.assertEquals(board.positions.get("c3").getSymbol(), "P");
        org.junit.jupiter.api.Assertions.assertNull(board.positions.get("c5"));
        org.junit.jupiter.api.Assertions.assertNull(board.positions.get("c4"));
    }

    @Test
    public void invalidForwardPawnDoubleDoubleMoveTest() {
        board.move("c2c4");
        board.move("a7a6");
        board.move("c4c6");
        org.junit.jupiter.api.Assertions.assertFalse(board.legal);
        org.junit.jupiter.api.Assertions.assertEquals(board.positions.get("c4").getSymbol(), "P");
        org.junit.jupiter.api.Assertions.assertNull(board.positions.get("c5"));
        org.junit.jupiter.api.Assertions.assertNull(board.positions.get("c6"));
    }

    @Test
    public void validPawnTakesTest() {
        org.junit.jupiter.api.Assertions.assertEquals(board.positions.get("b3").getSymbol(), "N");
        board.move("c2b3");
        org.junit.jupiter.api.Assertions.assertTrue(board.legal);
        org.junit.jupiter.api.Assertions.assertEquals(board.positions.get("b3").getSymbol(), "P");
    }

    @Test
    public void invalidPawnTakesTest() {
        org.junit.jupiter.api.Assertions.assertEquals(board.positions.get("b3").getSymbol(), "N");
        board.move("b2b3");
        org.junit.jupiter.api.Assertions.assertFalse(board.legal);
        org.junit.jupiter.api.Assertions.assertEquals(board.positions.get("b2").getSymbol(), "P");
        org.junit.jupiter.api.Assertions.assertEquals(board.positions.get("b3").getSymbol(), "N");
    }

    @Test
    public void invalidPawnTakesAndDoubleTest() {
        org.junit.jupiter.api.Assertions.assertEquals(board.positions.get("b3").getSymbol(), "N");
        board.move("c2b3");
        org.junit.jupiter.api.Assertions.assertTrue(board.legal);
        org.junit.jupiter.api.Assertions.assertEquals(board.positions.get("b3").getSymbol(), "P");
        board.move("b3b5");
        org.junit.jupiter.api.Assertions.assertFalse(board.legal);
        org.junit.jupiter.api.Assertions.assertEquals(board.positions.get("b3").getSymbol(), "P");
        org.junit.jupiter.api.Assertions.assertNull(board.positions.get("b4"));
        org.junit.jupiter.api.Assertions.assertNull(board.positions.get("b5"));
    }

    @Test
    public void validPawnTakesAndMoveTest() {
        org.junit.jupiter.api.Assertions.assertEquals(board.positions.get("b3").getSymbol(), "N");
        board.move("c2b3");
        org.junit.jupiter.api.Assertions.assertTrue(board.legal);
        org.junit.jupiter.api.Assertions.assertEquals(board.positions.get("b3").getSymbol(), "P");
        board.move("b3b4");
        org.junit.jupiter.api.Assertions.assertTrue(board.legal);
        org.junit.jupiter.api.Assertions.assertEquals(board.positions.get("b4").getSymbol(), "P");
    }
    
}
