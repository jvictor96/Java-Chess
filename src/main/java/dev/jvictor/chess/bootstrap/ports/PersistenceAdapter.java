package dev.jvictor.chess.bootstrap.ports;

import dev.jvictor.chess.core.Board;

public abstract class PersistenceAdapter {
    public abstract Board getBoard(int id);
    public abstract void saveBoard(int id, Board board);
    public abstract int getNextId();
    public abstract void listGames();
}
