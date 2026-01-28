package dev.jvictor.chess.machinecore.shell;

import dev.jvictor.chess.bootstrap.ports.Keyboard;
import dev.jvictor.chess.bootstrap.ports.PersistenceAdapter;
import dev.jvictor.chess.core.Board;
import dev.jvictor.chess.machinecore.ports.ShellStateHandler;

public class ResignCommand implements ShellStateHandler {

    PersistenceAdapter persistenceAdapter;
    Keyboard keyboard;
    String user;

    public ResignCommand(PersistenceAdapter persistenceAdapter, Keyboard keyboard, String user) {
        this.persistenceAdapter = persistenceAdapter;
        this.keyboard = keyboard;
        this.user = user;
    }

    @Override
    public ShellState handle() {
        persistenceAdapter.listGames();
        int id = Integer.parseInt(keyboard.read("which game? ").strip());
        Board board = persistenceAdapter.getBoard(id);
        board.winner = user == board.white ? board.black : board.white;
        persistenceAdapter.saveBoard(id, board);
        return ShellState.READING;
    }
    
}
