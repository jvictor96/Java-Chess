package dev.jvictor.chess.bootstrap.ports;

import java.util.List;
import java.util.Optional;

import dev.jvictor.chess.core.Board;

public interface PersistenceAdapter {
    public abstract Optional<Board> getBoard(int id);
    public abstract void saveBoard(int id, Board board);
    public abstract int getNextId();
    public abstract List<Board> listGames();
}
