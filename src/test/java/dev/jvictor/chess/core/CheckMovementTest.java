package dev.jvictor.chess.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CheckMovementTest {
    
    Board kingInCheckByBishop, pastor, blackBishopOut, blackBishopOutAndOpenKingPawn;

    @BeforeEach
    public void resetBoard() {
        pastor = new Board();
        pastor.moveWithoutValidation(pastor.buildMovement("e2e4"));
        pastor.moveWithoutValidation(pastor.buildMovement("f1c4"));
        pastor.moveWithoutValidation(pastor.buildMovement("d1f3"));
        pastor.white = "jose";
        pastor.black = "mike";
        kingInCheckByBishop = new Board();
        kingInCheckByBishop.moveWithoutValidation(kingInCheckByBishop.buildMovement("d2d4"));
        kingInCheckByBishop.moveWithoutValidation(kingInCheckByBishop.buildMovement("e2e4"));
        kingInCheckByBishop.moveWithoutValidation(kingInCheckByBishop.buildMovement("f8b4"));
        blackBishopOut = new Board();
        blackBishopOut.moveWithoutValidation(blackBishopOut.buildMovement("f8b4"));
        blackBishopOutAndOpenKingPawn = new Board();
        blackBishopOutAndOpenKingPawn.moveWithoutValidation(blackBishopOutAndOpenKingPawn.buildMovement("e2e4"));
        blackBishopOutAndOpenKingPawn.moveWithoutValidation(blackBishopOutAndOpenKingPawn.buildMovement("c8g4"));
    }
    

    @Test
    public void kingMoveOutOfCheckTest() {
        kingInCheckByBishop.move(kingInCheckByBishop.buildMovement("e1e2"));
        Assertions.assertTrue(kingInCheckByBishop.legal);
    }

    @Test
    public void kingMoveIsStillInCheckTest() {
        kingInCheckByBishop.move(kingInCheckByBishop.buildMovement("e1d2"));
        Assertions.assertFalse(kingInCheckByBishop.legal);
    }

    @Test
    public void checkIsBlockedByQueenTest() {
        kingInCheckByBishop.move(kingInCheckByBishop.buildMovement("d1d2"));
        Assertions.assertTrue(kingInCheckByBishop.legal);
    }

    @Test
    public void queenMoveButStillCheckTest() {
        kingInCheckByBishop.move(kingInCheckByBishop.buildMovement("d1e2"));
        Assertions.assertFalse(kingInCheckByBishop.legal);
    }

    @Test
    public void pawnMovesButButsKingInCheckTest() {
        blackBishopOut.move(blackBishopOut.buildMovement("d2d3"));
        Assertions.assertFalse(blackBishopOut.legal);
    }

    @Test
    public void kingGoesToCheckTest() {
        blackBishopOutAndOpenKingPawn.move(blackBishopOutAndOpenKingPawn.buildMovement("e1e2"));
        Assertions.assertFalse(blackBishopOutAndOpenKingPawn.legal);
    }

    @Test
    public void checkMateTest() {
        pastor.move(pastor.buildMovement("f3f7"));
        Assertions.assertTrue(pastor.legal);
        Assertions.assertEquals("jose", pastor.white);
        Assertions.assertEquals("jose", pastor.winner);
    }
}
