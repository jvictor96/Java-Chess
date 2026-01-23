package dev.jvictor.chess.core.pieces;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import dev.jvictor.chess.core.Piece;
import dev.jvictor.chess.core.Position;

public class Rook extends Piece {
        public Rook(Position position) {
            this.position = position;
        }
        public boolean isMovementValid(Position destination) {
            return destination.x == position.x || destination.y == position.y;
        }

        public static List<Position> rookMiddlePaces(Position origin, Position destination) {
            return Map.of(
                destination.x > origin.x, IntStream.range(origin.x + 1, destination.x).mapToObj(i -> new Position(i, origin.y)).toList(),
                destination.x < origin.x, IntStream.range(destination.x + 1, origin.x).mapToObj(i -> new Position(i, origin.y)).toList(),
                destination.x > origin.x, IntStream.range(origin.y + 1, destination.y).mapToObj(i -> new Position(origin.x, i)).toList(),
                destination.x > origin.x, IntStream.range(destination.y + 1, origin.y).mapToObj(i -> new Position(origin.x, i)).toList(),
                destination.x == origin.x && destination.y == origin.y, new ArrayList<Position>()
            ).get(true);
        }

        public List<Position> getMiddlePlaces(Position destination) {
            if (!isMovementValid(destination)) return null;
            return rookMiddlePaces(position, destination);
        }

        public static List<Position> rookPossibleDestinations(Position origin) {
            List<Position> sameColumn = IntStream.range(1,9).mapToObj(y -> new Position(origin.x, y)).filter(p -> p.y != origin.y).toList();
            List<Position> sameRow = IntStream.range(1,9).mapToObj(y -> new Position(origin.x, y)).filter(p -> p.y != origin.y).toList();
            sameColumn.addAll(sameRow);
            return sameColumn;
        }

        public List<Position> getAllPossibleDestinations() {
            return rookPossibleDestinations(position);
        }
        public boolean isValidRoque(Position destination) {
            return false;
        }
        public String getSymbol(){
            return "R";
        }
    }
