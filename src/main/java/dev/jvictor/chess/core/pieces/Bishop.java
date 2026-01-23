package dev.jvictor.chess.core.pieces;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import dev.jvictor.chess.core.Piece;
import dev.jvictor.chess.core.Position;

public class Bishop extends Piece {
        public Bishop(Position position) {
            this.position = position;
        }
        
        public boolean isMovementValid(Position destination) {
            return Math.abs(destination.x-position.x) == Math.abs(destination.y-position.y);
        }

        public static List<Position> bishopMiddlePlaces(Position origin, Position destination) {
            return Map.of(
                destination.x > origin.x && destination.y > origin.y, 
                IntStream.range(destination.x, destination.x - origin.x).mapToObj(i -> new Position(origin.x + 1 + i, origin.y + 1 + i)).toList(),
                destination.x > origin.x && destination.y < origin.y, 
                IntStream.range(destination.x, destination.x - origin.x).mapToObj(i -> new Position(origin.x + 1 + i, origin.y - 1 - i)).toList(),
                destination.x < origin.x && destination.y < origin.y, 
                IntStream.range(origin.x, origin.x - destination.x).mapToObj(i -> new Position(destination.x + 1 + i, origin.y - 1 - i)).toList(),
                destination.x < origin.x && destination.y > origin.y, 
                IntStream.range(origin.x, origin.x - destination.x).mapToObj(i -> new Position(destination.x + 1 + i, origin.y + 1 + i)).toList(),
                destination.x == origin.x && destination.y == origin.y, new ArrayList<Position>()
            ).get(true);
        }

        public List<Position> getMiddlePlaces(Position destination) {
            if (!isMovementValid(destination)) return null;
            return bishopMiddlePlaces(position, destination);
        }

        public List<Position> getAllPossibleDestinations() {
            throw new UnsupportedOperationException("Not implemented yet");
        }

        public boolean isValidRoque(Position destination) {
            return false;
        }

        public String getSymbol(){
            return "B";
        }
    }
