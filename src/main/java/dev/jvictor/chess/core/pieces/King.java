package dev.jvictor.chess.core.pieces;

import java.util.ArrayList;
import java.util.List;

import dev.jvictor.chess.core.Piece;
import dev.jvictor.chess.core.Position;

public class King extends Piece {
    public King(Position position) {
        this.position = position;
    }
    public boolean isMovementValid(Position destination, Piece pieceThere) {
        return Math.abs(destination.x-position.x) < 2 && Math.abs(destination.y-position.y) < 2;
    }
    public List<Position> getMiddlePlaces(Position destination) {
        return new ArrayList<>();
    }
    public List<Position> getAllPossibleDestinations() {
        return List.of(
            position.add(1,1), position.add(-1, -1),
            position.add(1, -1), position.add(-1, 1),
            position.add(1, 0), position.add(-1, 0),
            position.add(0, 1), position.add(0, -1));
    }
    public boolean isValidRoque(Position destination) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
    public String getSymbol(){
        return "K";
    }
}
