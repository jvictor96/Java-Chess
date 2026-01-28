package dev.jvictor.chess.io;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import dev.jvictor.chess.bootstrap.ports.PersistenceAdapter;
import dev.jvictor.chess.core.Board;
 
public class InMemoryPersistence implements PersistenceAdapter {

    List<Board> boards = new ArrayList<>();
    int nextId = 0;

    @Override
    public Optional<Board> getBoard(int id) {
        return boards.stream().filter(b -> b.id == id).findFirst();
    }

    @Override
    public void saveBoard(int id, Board board) {
        board.id = id;
        boards.add(board);
    }

    @Override
    public int getNextId() {
        nextId ++;
        return nextId;
    }

    @Override
    public List<Board> listGames() {
        return boards;
    }
    
}
