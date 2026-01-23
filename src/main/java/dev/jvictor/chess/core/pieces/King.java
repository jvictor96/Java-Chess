package dev.jvictor.chess.core.pieces;

import java.util.List;

import dev.jvictor.chess.core.Piece;
import dev.jvictor.chess.core.Position;

public class King extends Piece {
    public King(Position position) {
        this.position = position;
    }
    public boolean isMovementValid() {
        throw new UnsupportedOperationException("Not implemented yet");
    }
    public List<Position> getMiddlePlaces() {
        throw new UnsupportedOperationException("Not implemented yet");
    }
    public List<Position> getAllPossibleDestinations() {
        throw new UnsupportedOperationException("Not implemented yet");
    }
    public boolean isValidRoque() {
        throw new UnsupportedOperationException("Not implemented yet");
    }
    public String getSymbol(){
        return "K";
    }
}
