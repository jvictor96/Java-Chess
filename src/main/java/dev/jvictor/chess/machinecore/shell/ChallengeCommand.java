package dev.jvictor.chess.machinecore.shell;

import dev.jvictor.chess.bootstrap.ports.Keyboard;
import dev.jvictor.chess.bootstrap.ports.PersistenceAdapter;
import dev.jvictor.chess.core.Board;
import dev.jvictor.chess.machinecore.ports.ShellStateHandler;

public class ChallengeCommand implements ShellStateHandler {

    PersistenceAdapter persistenceAdapter;
    Keyboard keyboard;
    String user;

    public ChallengeCommand(PersistenceAdapter persistenceAdapter, Keyboard keyboard, String user) {
        this.persistenceAdapter = persistenceAdapter;
        this.keyboard = keyboard;
        this.user = user;
    }

    @Override
    public ShellState handle() {
        String opponent = keyboard.read("who are you challenging? ").strip();
        Board board = new Board();
        board.white = user;
        board.black = opponent;
        persistenceAdapter.saveBoard(persistenceAdapter.getNextId(), board);
        return ShellState.READING;
    }
    
}
