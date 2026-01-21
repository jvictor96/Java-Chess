package dev.jvictor.chess.core;

import java.util.Dictionary;
import java.util.List;

public class Board {
    
    List<Piece> pieces;
    Dictionary<Position, Piece> positions;
    String white, black, winner;
    public boolean legal;

    Board() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public Board clone() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public void updatePositions(String movement) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public Board moveWithoutValidation(String movement) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public Board move(String movement) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

}
