package dev.jvictor.chess.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class QueenMovementTest {
    
    Board board;

    @BeforeEach
    public void resetBoard() {
        board = new Board();
    }

    @Test
    public void validForwardQueenMoveTest() {
        board.move("e4e5");
        org.junit.jupiter.api.Assertions.assertTrue(board.legal);
        org.junit.jupiter.api.Assertions.assertEquals(board.positions.get("e5").getSymbol(), "Q");
    }

    @Test
    public void validLeftQueenMoveTest() {
        board.move("e4c4");
        org.junit.jupiter.api.Assertions.assertTrue(board.legal);
        org.junit.jupiter.api.Assertions.assertEquals(board.positions.get("c4").getSymbol(), "Q");
    }

    @Test
    public void validBackwardQueenMoveTest() {
        board.move("e4e3");
        org.junit.jupiter.api.Assertions.assertTrue(board.legal);
        org.junit.jupiter.api.Assertions.assertEquals(board.positions.get("e3").getSymbol(), "Q");
    }

    @Test
    public void invalidQueenMoveTest() {
        board.move("e4a3");
        org.junit.jupiter.api.Assertions.assertFalse(board.legal);
        org.junit.jupiter.api.Assertions.assertEquals(board.positions.get("e4").getSymbol(), "Q");
        org.junit.jupiter.api.Assertions.assertNull(board.positions.get("a3"));
    }

    @Test
    public void invalidQueenMoveToBlockedPlaceTest() {
        board.move("e4e2");
        org.junit.jupiter.api.Assertions.assertFalse(board.legal);
        org.junit.jupiter.api.Assertions.assertEquals(board.positions.get("e4").getSymbol(), "Q");
        org.junit.jupiter.api.Assertions.assertEquals(board.positions.get("e2").getSymbol(), "P");
    }

    @Test
    public void invalidQueenJumpOverAllyTest() {
        board.move("e4h4");
        org.junit.jupiter.api.Assertions.assertFalse(board.legal);
        org.junit.jupiter.api.Assertions.assertEquals(board.positions.get("e4").getSymbol(), "Q");
        org.junit.jupiter.api.Assertions.assertEquals(board.positions.get("f4").getSymbol(), "P");
        org.junit.jupiter.api.Assertions.assertNull(board.positions.get("h4"));
    }

    @Test
    public void validQueenTakesLikeRookTest() {
        org.junit.jupiter.api.Assertions.assertEquals(board.positions.get("e7").getSymbol(), "P");
        board.move("e4e7");
        org.junit.jupiter.api.Assertions.assertTrue(board.legal);
        org.junit.jupiter.api.Assertions.assertEquals(board.positions.get("e7").getSymbol(), "Q");
    }

    @Test
    public void invalidQueenTakesOverOtherPieceTest() {
        board.move("e4e8");
        org.junit.jupiter.api.Assertions.assertFalse(board.legal);
        org.junit.jupiter.api.Assertions.assertEquals(board.positions.get("d7").getSymbol(), "P");
        org.junit.jupiter.api.Assertions.assertEquals(board.positions.get("e8").getSymbol(), "K");
        org.junit.jupiter.api.Assertions.assertEquals(board.positions.get("d4").getSymbol(), "Q");
    }

    @Test
    public void invalidQueenTakesTest() {
        board.move("d4e7");
        org.junit.jupiter.api.Assertions.assertFalse(board.legal);
        org.junit.jupiter.api.Assertions.assertEquals(board.positions.get("d4").getSymbol(), "Q");
        org.junit.jupiter.api.Assertions.assertEquals(board.positions.get("e7").getSymbol(), "P");
        org.junit.jupiter.api.Assertions.assertNull(board.positions.get("e5"));
        org.junit.jupiter.api.Assertions.assertNull(board.positions.get("e6"));
        org.junit.jupiter.api.Assertions.assertNull(board.positions.get("d5"));
        org.junit.jupiter.api.Assertions.assertNull(board.positions.get("d6"));
    }

    @Test
    public void validForwardLeftQueenMoveTest() {
        board.move("e4d5");
        org.junit.jupiter.api.Assertions.assertTrue(board.legal);
        org.junit.jupiter.api.Assertions.assertEquals(board.positions.get("d5").getSymbol(), "Q");
    }

    @Test
    public void validBackwardLeftQueenMoveTest() {
        board.move("e4d3");
        org.junit.jupiter.api.Assertions.assertTrue(board.legal);
        org.junit.jupiter.api.Assertions.assertEquals(board.positions.get("d3").getSymbol(), "Q");
    }

    @Test
    public void validBackwardRightQueenMoveTest() {
        board.move("e4f3");
        org.junit.jupiter.api.Assertions.assertTrue(board.legal);
        org.junit.jupiter.api.Assertions.assertEquals(board.positions.get("f3").getSymbol(), "Q");
    }

    @Test
    public void validQueenTakesLikeBishopTest() {
        org.junit.jupiter.api.Assertions.assertEquals(board.positions.get("h7").getSymbol(), "P");
        board.move("e4h7");
        org.junit.jupiter.api.Assertions.assertTrue(board.legal);
        org.junit.jupiter.api.Assertions.assertEquals(board.positions.get("h7").getSymbol(), "Q");
    }
}
