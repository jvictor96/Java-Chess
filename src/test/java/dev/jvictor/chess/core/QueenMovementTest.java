package dev.jvictor.chess.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class QueenMovementTest {
    
    Board board;

    @BeforeEach
    public void resetBoard() {
        board = new Board();
        board.moveWithoutValidation(board.buildMovement("d1e4"));
    }

    @Test
    public void validForwardQueenMoveTest() {
        board.move(board.buildMovement("e4e5"));
        org.junit.jupiter.api.Assertions.assertTrue(board.legal);
        org.junit.jupiter.api.Assertions.assertEquals(board.getPieceAt("e5").getSymbol(), "Q");
    }

    @Test
    public void validLeftQueenMoveTest() {
        board.move(board.buildMovement("e4c4"));
        org.junit.jupiter.api.Assertions.assertTrue(board.legal);
        org.junit.jupiter.api.Assertions.assertEquals(board.getPieceAt("c4").getSymbol(), "Q");
    }

    @Test
    public void validBackwardQueenMoveTest() {
        board.move(board.buildMovement("e4e3"));
        org.junit.jupiter.api.Assertions.assertTrue(board.legal);
        org.junit.jupiter.api.Assertions.assertEquals(board.getPieceAt("e3").getSymbol(), "Q");
    }

    @Test
    public void invalidQueenMoveTest() {
        board.move(board.buildMovement("e4a3"));
        org.junit.jupiter.api.Assertions.assertFalse(board.legal);
        org.junit.jupiter.api.Assertions.assertEquals(board.getPieceAt("e4").getSymbol(), "Q");
        org.junit.jupiter.api.Assertions.assertNull(board.getPieceAt("a3"));
    }

    @Test
    public void invalidQueenMoveToBlockedPlaceTest() {
        board.move(board.buildMovement("e4e2"));
        org.junit.jupiter.api.Assertions.assertFalse(board.legal);
        org.junit.jupiter.api.Assertions.assertEquals(board.getPieceAt("e4").getSymbol(), "Q");
        org.junit.jupiter.api.Assertions.assertEquals(board.getPieceAt("e2").getSymbol(), "P");
    }

    @Test
    public void invalidQueenJumpOverAllyTest() {
        board.move(board.buildMovement("e4e1"));
        org.junit.jupiter.api.Assertions.assertEquals(board.getPieceAt("e2").getSymbol(), "P");
        org.junit.jupiter.api.Assertions.assertEquals(board.getPieceAt("e4").getSymbol(), "Q");
        org.junit.jupiter.api.Assertions.assertNull(board.getPieceAt("h4"));
        org.junit.jupiter.api.Assertions.assertFalse(board.legal);
    }

    @Test
    public void validQueenTakesLikeRookTest() {
        org.junit.jupiter.api.Assertions.assertEquals(board.getPieceAt("e7").getSymbol(), "P");
        board.move(board.buildMovement("e4e7"));
        org.junit.jupiter.api.Assertions.assertTrue(board.legal);
        org.junit.jupiter.api.Assertions.assertEquals(board.getPieceAt("e7").getSymbol(), "Q");
    }

    @Test
    public void invalidQueenTakesOverOtherPieceTest() {
        board.move(board.buildMovement("e4e8"));
        org.junit.jupiter.api.Assertions.assertFalse(board.legal);
        org.junit.jupiter.api.Assertions.assertEquals(board.getPieceAt("d7").getSymbol(), "P");
        org.junit.jupiter.api.Assertions.assertEquals(board.getPieceAt("e8").getSymbol(), "K");
        org.junit.jupiter.api.Assertions.assertEquals(board.getPieceAt("e4").getSymbol(), "Q");
    }

    @Test
    public void invalidQueenTakesTest() {
        board.move(board.buildMovement("e4d7"));
        org.junit.jupiter.api.Assertions.assertFalse(board.legal);
        org.junit.jupiter.api.Assertions.assertEquals(board.getPieceAt("e4").getSymbol(), "Q");
        org.junit.jupiter.api.Assertions.assertEquals(board.getPieceAt("d7").getSymbol(), "P");
        org.junit.jupiter.api.Assertions.assertNull(board.getPieceAt("e5"));
        org.junit.jupiter.api.Assertions.assertNull(board.getPieceAt("e6"));
        org.junit.jupiter.api.Assertions.assertNull(board.getPieceAt("d5"));
        org.junit.jupiter.api.Assertions.assertNull(board.getPieceAt("d6"));
    }

    @Test
    public void validForwardLeftQueenMoveTest() {
        board.move(board.buildMovement("e4d5"));
        org.junit.jupiter.api.Assertions.assertTrue(board.legal);
        org.junit.jupiter.api.Assertions.assertEquals(board.getPieceAt("d5").getSymbol(), "Q");
    }

    @Test
    public void validBackwardLeftQueenMoveTest() {
        board.move(board.buildMovement("e4d3"));
        org.junit.jupiter.api.Assertions.assertTrue(board.legal);
        org.junit.jupiter.api.Assertions.assertEquals(board.getPieceAt("d3").getSymbol(), "Q");
    }

    @Test
    public void validBackwardRightQueenMoveTest() {
        board.move(board.buildMovement("e4f3"));
        org.junit.jupiter.api.Assertions.assertTrue(board.legal);
        org.junit.jupiter.api.Assertions.assertEquals(board.getPieceAt("f3").getSymbol(), "Q");
    }

    @Test
    public void validQueenTakesLikeBishopTest() {
        org.junit.jupiter.api.Assertions.assertEquals(board.getPieceAt("h7").getSymbol(), "P");
        board.move(board.buildMovement("e4h7"));
        org.junit.jupiter.api.Assertions.assertTrue(board.legal);
        org.junit.jupiter.api.Assertions.assertEquals(board.getPieceAt("h7").getSymbol(), "Q");
    }
}
