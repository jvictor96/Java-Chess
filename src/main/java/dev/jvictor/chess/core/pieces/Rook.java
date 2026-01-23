package dev.jvictor.chess.core.pieces;

import java.util.List;
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
        public List<Position> getMiddlePlaces(Position destination) {
            throw new UnsupportedOperationException("Not implemented yet");
        }
        public List<Position> getAllPossibleDestinations() {
            List<Position> sameColumn = IntStream.range(1,9).mapToObj(y -> new Position(position.x, y)).filter(p -> p.y != position.y).toList();
            List<Position> sameRow = IntStream.range(1,9).mapToObj(y -> new Position(position.x, y)).filter(p -> p.y != position.y).toList();
            throw new UnsupportedOperationException("Not implemented yet");
        }
        public boolean isValidRoque(Position destination) {
            return false;
        }
        public String getSymbol(){
            return "R";
        }
    }
