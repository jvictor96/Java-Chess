package dev.jvictor.chess.bootstrap.ports;

import dev.jvictor.chess.core.Board;

public interface GameViewer {
    public abstract void display(Board board);
}
