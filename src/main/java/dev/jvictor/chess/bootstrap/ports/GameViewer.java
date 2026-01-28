package dev.jvictor.chess.bootstrap.ports;

import dev.jvictor.chess.core.Board;

public abstract class GameViewer {
    public abstract void display(Board board);
}
