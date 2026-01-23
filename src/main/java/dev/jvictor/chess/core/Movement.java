package dev.jvictor.chess.core;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class Movement {
    public Position from, to;
    Map<Position, Piece> positions;
    Piece piece;

    Movement(Position from, Position to, Map<Position, Piece> positions) {
        this.positions = positions;
        this.from = from;
        this.to = to;
        piece = positions.get(from);
    }

    public static Movement fromString(String movement, Map<Position, Piece> positions) {
        return new Movement(Position.fromString(movement.substring(0, 2)), Position.fromString(movement.substring(2, 4)), positions);
    }

    public static Movement fromString(String movement) {
        return new Movement(Position.fromString(movement.substring(0, 2)), Position.fromString(movement.substring(2, 4)), new HashMap<>());
    }

    public boolean isMovementValid() {
        if (piece == null) return false;
        return Stream.of(
            isPieceWiseValid(),
            isPathClear(),
            isAnActualMovement(),
            isDestinationFree(),
            isDestinationValid()
        ).allMatch(Boolean::booleanValue);
    }

    private boolean isPieceWiseValid() {
        return piece.isMovementValid(to);
    }

    private boolean isPathClear() {
        return piece.getMiddlePlaces(to).stream().noneMatch(positions::containsKey);
    }

    private boolean isDestinationFree() {
        return positions.get(to) == null || positions.get(to).color != piece.color;
    }

    private boolean isAnActualMovement() {
        return to != from;
    }

    private boolean isDestinationValid() {
        return to.isValid();
    }
}
