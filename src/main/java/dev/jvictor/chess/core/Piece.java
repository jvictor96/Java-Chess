package dev.jvictor.chess.core;

import java.util.List;

public abstract class Piece {
    abstract boolean isMovementValid();
    abstract List<Position> getMiddlePlaces();
    abstract List<Position> getAllPossibleDestinations();
    abstract boolean isValidRoque();

    public class Pawn extends Piece {
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
    }

    public class Rook extends Piece {
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
    }

    public class Knight extends Piece {
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
    }

    public class Bishop extends Piece {
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
    }

    public class King extends Piece {
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
    }

    public class Queen extends Piece {
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
    }
}
