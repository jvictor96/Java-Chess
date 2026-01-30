package dev.jvictor.chess.io;

import dev.jvictor.chess.bootstrap.ports.GameViewer;
import dev.jvictor.chess.core.Board;

public class NoViewAdapter implements GameViewer {

    @Override
    public void display(Board board) {
    }
    
}
