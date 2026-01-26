package dev.jvictor.chess.core;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import dev.jvictor.chess.core.Piece.Color;

import java.util.ArrayList;
import java.util.List;

public class Board {
    
    List<Piece> pieces;
    Map<Position, Piece> positions;
    String white, black, winner;
    public boolean legal;

    Board() {
        pieces = new ArrayList<>();
        IntStream.range(1,9).forEach(i -> pieces.add(Piece.fromType("P", Color.WHITE, new Position(i, 2))));
        IntStream.range(1,9).forEach(i -> pieces.add(Piece.fromType("P", Color.BLACK, new Position(i, 7))));
        pieces.add(Piece.fromType("R", Color.WHITE, new Position(1, 1)));
        pieces.add(Piece.fromType("N", Color.WHITE, new Position(2, 1)));
        pieces.add(Piece.fromType("B", Color.WHITE, new Position(3, 1)));
        pieces.add(Piece.fromType("Q", Color.WHITE, new Position(4, 1)));
        pieces.add(Piece.fromType("K", Color.WHITE, new Position(5, 1)));
        pieces.add(Piece.fromType("B", Color.WHITE, new Position(6, 1)));
        pieces.add(Piece.fromType("N", Color.WHITE, new Position(7, 1)));
        pieces.add(Piece.fromType("R", Color.WHITE, new Position(8, 1)));
        pieces.add(Piece.fromType("R", Color.BLACK, new Position(1, 8)));
        pieces.add(Piece.fromType("N", Color.BLACK, new Position(2, 8)));
        pieces.add(Piece.fromType("B", Color.BLACK, new Position(3, 8)));
        pieces.add(Piece.fromType("Q", Color.BLACK, new Position(4, 8)));
        pieces.add(Piece.fromType("K", Color.BLACK, new Position(5, 8)));
        pieces.add(Piece.fromType("B", Color.BLACK, new Position(6, 8)));
        pieces.add(Piece.fromType("N", Color.BLACK, new Position(7, 8)));
        pieces.add(Piece.fromType("R", Color.BLACK, new Position(8, 8)));
        positions = pieces.stream().collect(Collectors.toMap(Piece::getPosition, Function.identity()));
    }

    public Board clone() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public Piece getPieceAt(String position) {
        return positions.get(Position.fromString(position));
    }

    public boolean isColorInCheck(Piece.Color color) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public boolean isColorInCheckMate(Piece.Color color) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public void updatePositions(String movement) {
        Movement parsedMovement = Movement.fromString(movement, positions);
        parsedMovement.piece.position = parsedMovement.to;
        positions.put(parsedMovement.to, positions.get(parsedMovement.from));
        positions.remove(parsedMovement.from);
    }

    public Board moveWithoutValidation(String movement) {
        updatePositions(movement);
        return this;
    }

    public Board move(String movement) {
        legal = Movement.fromString(movement, positions).isMovementValid();
        if (legal) updatePositions(movement);
        return this;

    }

}
