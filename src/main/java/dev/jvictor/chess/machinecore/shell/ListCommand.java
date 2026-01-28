package dev.jvictor.chess.machinecore.shell;

import dev.jvictor.chess.bootstrap.ports.PersistenceAdapter;
import dev.jvictor.chess.machinecore.ports.ShellStateHandler;

public class ListCommand implements ShellStateHandler {

    PersistenceAdapter persistenceAdapter;

    public ListCommand(PersistenceAdapter persistenceAdapter) {
        this.persistenceAdapter = persistenceAdapter;
    }

    @Override
    public ShellState handle() {
        persistenceAdapter.listGames();
        return ShellState.READING;
    }
    
}
