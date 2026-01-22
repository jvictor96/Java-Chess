package dev.jvictor.chess.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CheckMovementTest {
    
    Board board, kinInCheckByBishop, pastor, blackBishopOut, blackBishopOutAndOpenKingPawn;

    @BeforeEach
    public void resetBoard() {
        board = new Board();
    }
    

    @Test
    public void kingMoveOutOfCheckTest() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Test
    public void kingMoveIsStillInCheckTest() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Test
    public void checkIsBlockedByQueenTest() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Test
    public void queenMoveButStillCheckTest() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Test
    public void pawnMovesButButsKingInCheckTest() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Test
    public void kingGoesToCheckTest() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Test
    public void checkMateTest() {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
