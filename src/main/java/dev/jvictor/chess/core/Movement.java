package dev.jvictor.chess.core;

import java.util.HashMap;
import java.util.Map;

public class Movement {
    public Position from, to;
    Map<Position, Piece> positions;

    Movement(Position from, Position to, Map<Position, Piece> positions) {
        this.positions = positions;
        this.from = from;
        this.to = to;
    }

    public static Movement fromString(String movement, Map<Position, Piece> positions) {
        return new Movement(Position.fromString(movement.substring(0, 2)), Position.fromString(movement.substring(2, 4)), positions);
    }

    public static Movement fromString(String movement) {
        return new Movement(Position.fromString(movement.substring(0, 2)), Position.fromString(movement.substring(2, 4)), new HashMap<>());
    }
}
