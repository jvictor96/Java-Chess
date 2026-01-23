package dev.jvictor.chess.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BasicTests {
    
    Board board;

    @BeforeEach
    public void resetBoard() {
        board = new Board();
    }

    @Test
    public void positionsTest() {
        Assertions.assertEquals(board.positions.size(), 32); 
    }

    @Test
    public void piecesTests() {
        Assertions.assertEquals(board.pieces.size(), 32); 
    }
}
