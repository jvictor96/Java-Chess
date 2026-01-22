package dev.jvictor.chess.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BishopMovementTest {
    
    Board board;

    @BeforeEach
    public void resetBoard() {
        board = new Board();
    }

    @Test
    public void validForwardLeftBishopMoveTest() {
        board.move("e4d5");
        org.junit.jupiter.api.Assertions.assertTrue(board.legal);
        org.junit.jupiter.api.Assertions.assertEquals(board.positions.get("d5").getSymbol(), "B");
    }

    @Test
    public void validBackwardLeftBishopMoveTest() {
        board.move("e4d3");
        org.junit.jupiter.api.Assertions.assertTrue(board.legal);
        org.junit.jupiter.api.Assertions.assertEquals(board.positions.get("d3").getSymbol(), "B");
    }

    @Test
    public void validBackwardRightBishopMoveTest() {
        board.move("e4f3");
        org.junit.jupiter.api.Assertions.assertTrue(board.legal);
        org.junit.jupiter.api.Assertions.assertEquals(board.positions.get("f3").getSymbol(), "B");
    }

    @Test
    public void invalidBishopMoveTest() {
        board.move("e4e3");
        org.junit.jupiter.api.Assertions.assertFalse(board.legal);
        org.junit.jupiter.api.Assertions.assertEquals(board.positions.get("e4").getSymbol(), "B");
        org.junit.jupiter.api.Assertions.assertNull(board.positions.get("e3"));
    }

    @Test
    public void invalidBishopMoveToBlockedPlaceTest() {
        board.move("e4c2");
        org.junit.jupiter.api.Assertions.assertFalse(board.legal);
        org.junit.jupiter.api.Assertions.assertEquals(board.positions.get("e4").getSymbol(), "B");
        org.junit.jupiter.api.Assertions.assertEquals(board.positions.get("c2").getSymbol(), "P");
    }

    @Test
    public void invalidBishopJumpOverAllyTest() {
        board.move("e4h1");
        org.junit.jupiter.api.Assertions.assertFalse(board.legal);
        org.junit.jupiter.api.Assertions.assertEquals(board.positions.get("e4").getSymbol(), "B");
        org.junit.jupiter.api.Assertions.assertEquals(board.positions.get("g2").getSymbol(), "P");
        org.junit.jupiter.api.Assertions.assertNull(board.positions.get("h1"));
    }

    @Test
    public void invalidBishopJumpOverOpponentTest() {
        board.move("e4a8");
        org.junit.jupiter.api.Assertions.assertFalse(board.legal);
        org.junit.jupiter.api.Assertions.assertEquals(board.positions.get("e4").getSymbol(), "B");
        org.junit.jupiter.api.Assertions.assertEquals(board.positions.get("b7").getSymbol(), "P");
        org.junit.jupiter.api.Assertions.assertNull(board.positions.get("a8"));
    }

    @Test
    public void validBishopTakesTest() {
        org.junit.jupiter.api.Assertions.assertEquals(board.positions.get("h7").getSymbol(), "P");
        board.move("e4h7");
        org.junit.jupiter.api.Assertions.assertTrue(board.legal);
        org.junit.jupiter.api.Assertions.assertEquals(board.positions.get("h7").getSymbol(), "B");
    }

    @Test
    public void invalidBishopTakesOverOtherPieceTest() {
        board.move("d4h8");
        org.junit.jupiter.api.Assertions.assertFalse(board.legal);
        org.junit.jupiter.api.Assertions.assertEquals(board.positions.get("g7").getSymbol(), "P");
        org.junit.jupiter.api.Assertions.assertEquals(board.positions.get("h8").getSymbol(), "R");
        org.junit.jupiter.api.Assertions.assertEquals(board.positions.get("d4").getSymbol(), "B");
    }

    @Test
    public void invalidBishopTakesTest() {
        board.move("d4d7");
        org.junit.jupiter.api.Assertions.assertFalse(board.legal);
        org.junit.jupiter.api.Assertions.assertEquals(board.positions.get("d4").getSymbol(), "B");
        org.junit.jupiter.api.Assertions.assertEquals(board.positions.get("d7").getSymbol(), "P");
        org.junit.jupiter.api.Assertions.assertNull(board.positions.get("d5"));
        org.junit.jupiter.api.Assertions.assertNull(board.positions.get("d6"));
    }
}
