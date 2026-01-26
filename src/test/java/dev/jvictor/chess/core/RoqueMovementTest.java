package dev.jvictor.chess.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RoqueMovementTest {
    
    Board board, blockedByKnight, blockedByBishop, blockedByQueen;

    @BeforeEach
    public void resetBoard() {
        board = new Board();
        board.moveWithoutValidation(board.buildMovement("b1b4"));
        board.moveWithoutValidation(board.buildMovement("c1c4"));
        board.moveWithoutValidation(board.buildMovement("d1d4"));
        board.moveWithoutValidation(board.buildMovement("f1f4"));
        board.moveWithoutValidation(board.buildMovement("g1g4"));
        board.moveWithoutValidation(board.buildMovement("e2e3"));
        board.moveWithoutValidation(board.buildMovement("a2a3"));
        board.moveWithoutValidation(board.buildMovement("h2h3"));
        blockedByKnight = new Board();
        blockedByKnight.moveWithoutValidation(blockedByKnight.buildMovement("c1c4"));
        blockedByKnight.moveWithoutValidation(blockedByKnight.buildMovement("d1d4"));
        blockedByKnight.moveWithoutValidation(blockedByKnight.buildMovement("f1f4"));
        blockedByKnight.moveWithoutValidation(blockedByKnight.buildMovement("e2e3"));
        blockedByBishop = new Board();
        blockedByBishop.moveWithoutValidation(blockedByBishop.buildMovement("b1c4"));
        blockedByBishop.moveWithoutValidation(blockedByBishop.buildMovement("d1d4"));
        blockedByBishop.moveWithoutValidation(blockedByBishop.buildMovement("g1f4"));
        blockedByBishop.moveWithoutValidation(blockedByBishop.buildMovement("e2e3"));
        blockedByQueen = new Board();
        blockedByQueen.moveWithoutValidation(blockedByQueen.buildMovement("b1b4"));
        blockedByQueen.moveWithoutValidation(blockedByQueen.buildMovement("c1c4"));
        blockedByQueen.moveWithoutValidation(blockedByQueen.buildMovement("f1f4"));
        blockedByQueen.moveWithoutValidation(blockedByQueen.buildMovement("g1g4"));
        blockedByQueen.moveWithoutValidation(blockedByQueen.buildMovement("e2e3"));
    }

    @Test
    public void minorRoqueTest() {
        board.move(board.buildMovement("e1g1"));
        Assertions.assertTrue(board.legal);
        Assertions.assertEquals(board.getPieceAt("f1").getSymbol(), "R");
        Assertions.assertEquals(board.getPieceAt("g1").getSymbol(), "K");
        board.move(board.buildMovement("a7a6"));
        Assertions.assertTrue(board.legal);
    }

    @Test
    public void majorRoqueTest() {
        board.move(board.buildMovement("e1c1"));
        Assertions.assertTrue(board.legal);
        Assertions.assertEquals(board.getPieceAt("d1").getSymbol(), "R");
        Assertions.assertEquals(board.getPieceAt("c1").getSymbol(), "K");
        board.move(board.buildMovement("a7a6"));
        Assertions.assertTrue(board.legal);
    }

    @Test
    public void blockedByKnightMinorRoqueTest() {
        blockedByKnight.move(blockedByKnight.buildMovement("e1g1"));
        Assertions.assertFalse(blockedByKnight.legal);
        Assertions.assertEquals(blockedByKnight.getPieceAt("h1").getSymbol(), "R");
        Assertions.assertEquals(blockedByKnight.getPieceAt("e1").getSymbol(), "K");
        blockedByKnight.move(blockedByKnight.buildMovement("e1e2"));
        Assertions.assertTrue(blockedByKnight.legal);
    }

    @Test
    public void blockedByKnightMajorRoqueTest() {
        blockedByKnight.move(blockedByKnight.buildMovement("e1c1"));
        Assertions.assertFalse(blockedByKnight.legal);
        Assertions.assertEquals(blockedByKnight.getPieceAt("a1").getSymbol(), "R");
        Assertions.assertEquals(blockedByKnight.getPieceAt("e1").getSymbol(), "K");
        blockedByKnight.move(blockedByKnight.buildMovement("e1e2"));
        Assertions.assertTrue(blockedByKnight.legal);
    }

    @Test
    public void blockedByBishopMinorRoqueTest() {
        blockedByBishop.move(blockedByBishop.buildMovement("e1g1"));
        Assertions.assertFalse(blockedByBishop.legal);
        Assertions.assertEquals(blockedByBishop.getPieceAt("h1").getSymbol(), "R");
        Assertions.assertEquals(blockedByBishop.getPieceAt("e1").getSymbol(), "K");
        blockedByBishop.move(blockedByBishop.buildMovement("e1e2"));
        Assertions.assertTrue(blockedByBishop.legal);
    }

    @Test
    public void blockedByBishopMajorRoqueTest() {
        blockedByBishop.move(blockedByBishop.buildMovement("e1c1"));
        Assertions.assertFalse(blockedByBishop.legal);
        Assertions.assertEquals(blockedByBishop.getPieceAt("a1").getSymbol(), "R");
        Assertions.assertEquals(blockedByBishop.getPieceAt("e1").getSymbol(), "K");
        blockedByBishop.move(blockedByBishop.buildMovement("e1e2"));
        Assertions.assertTrue(blockedByBishop.legal);
    }

    @Test
    public void blockedByQueenMajorRoqueTest() {
        blockedByQueen.move(blockedByQueen.buildMovement("e1c1"));
        Assertions.assertFalse(blockedByQueen.legal);
        Assertions.assertEquals(blockedByQueen.getPieceAt("a1").getSymbol(), "R");
        Assertions.assertEquals(blockedByQueen.getPieceAt("e1").getSymbol(), "K");
        blockedByQueen.move(blockedByQueen.buildMovement("e1e2"));
        Assertions.assertTrue(blockedByQueen.legal);
    }

    @Test
    public void absentRookRoqueTest() {
        board.move(board.buildMovement("a1a2"));
        board.move(board.buildMovement("a7a6"));
        board.move(board.buildMovement("e1c1"));
        Assertions.assertFalse(board.legal);
        Assertions.assertEquals(board.getPieceAt("e1").getSymbol(), "K");
        board.move(board.buildMovement("e1e2"));
        Assertions.assertTrue(board.legal);
    }

    @Test
    public void movedKingRoqueTest() {
        board.move(board.buildMovement("e1e2"));
        board.move(board.buildMovement("a7a6"));
        board.move(board.buildMovement("e2e1"));
        board.move(board.buildMovement("a6a5"));
        board.move(board.buildMovement("e1g1"));
        Assertions.assertFalse(board.legal);
        Assertions.assertEquals(board.getPieceAt("a1").getSymbol(), "R");
        Assertions.assertEquals(board.getPieceAt("e1").getSymbol(), "K");
        board.move(board.buildMovement("e1e2"));
        Assertions.assertTrue(board.legal);
    }

    @Test
    public void movedRookRoqueTest() {
        board.move(board.buildMovement("a1a2"));
        board.move(board.buildMovement("a7a6"));
        board.move(board.buildMovement("a2a1"));
        board.move(board.buildMovement("a6a5"));
        board.move(board.buildMovement("e1c1"));
        Assertions.assertFalse(board.legal);
        Assertions.assertEquals(board.getPieceAt("a1").getSymbol(), "R");
        Assertions.assertEquals(board.getPieceAt("e1").getSymbol(), "K");
        board.move(board.buildMovement("e1e2"));
        Assertions.assertTrue(board.legal);
    }
    
}
