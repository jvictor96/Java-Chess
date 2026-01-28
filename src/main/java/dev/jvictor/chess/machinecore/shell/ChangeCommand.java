package dev.jvictor.chess.machinecore.shell;

import dev.jvictor.chess.machinecore.players.MovementMachine;
import dev.jvictor.chess.machinecore.players.OpponentHandler;
import dev.jvictor.chess.machinecore.players.YourHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import dev.jvictor.chess.bootstrap.ports.Keyboard;
import dev.jvictor.chess.bootstrap.ports.PersistenceAdapter;
import dev.jvictor.chess.core.Board;
import dev.jvictor.chess.machinecore.ports.MessageCrossing;
import dev.jvictor.chess.machinecore.ports.MessageCrossingFactory;
import dev.jvictor.chess.machinecore.ports.ShellStateHandler;
import dev.jvictor.chess.machinecore.ports.MovementStateHandler.MovementState;

public class ChangeCommand implements ShellStateHandler {

    MessageCrossingFactory messageCrossingFactory;
    PersistenceAdapter persistenceAdapter;
    List<String> movements, opponentMovements;
    Keyboard keyboard;
    String user;
    CompletableFuture<?> game;
    ExecutorService gameExecutor = Executors.newSingleThreadExecutor();

    public ChangeCommand(PersistenceAdapter persistenceAdapter, Keyboard keyboard, List<String> movements, String user, MessageCrossingFactory messageCrossingFactory) {
        this.persistenceAdapter = persistenceAdapter;
        this.keyboard = keyboard;
        this.messageCrossingFactory = messageCrossingFactory;
        this.movements = movements;
        this.opponentMovements = new ArrayList<>();
        this.user = user;
        gameExecutor = Executors.newSingleThreadExecutor();
    }

    @Override
    public ShellState handle() {
        persistenceAdapter.listGames();
        int id = Integer.parseInt(keyboard.read("which game? ").strip());
        Board board = persistenceAdapter.getBoard(id);
        if (game != null && !game.isDone()) game.cancel(true);
        String opponent = board.white == user ? board.black : board.white;
        MessageCrossing messageCrossing = messageCrossingFactory.getMessageCrossing(user, opponent);
        opponentMovements.forEach(messageCrossing::send);
        MovementMachine movementMachine = new MovementMachine(Map.of(
            MovementState.YOUR_TURN, new YourHandler(movements, messageCrossing, persistenceAdapter, id),
            MovementState.THEIR_TURN, new OpponentHandler(movements, messageCrossing, persistenceAdapter, id)
        ));
        game = CompletableFuture.supplyAsync(() -> movementMachine.mainLoop(), gameExecutor);
        persistenceAdapter.saveBoard(persistenceAdapter.getNextId(), board);
        return ShellState.READING;
    }
    
    public void registerOpponentMovements(List<String> movements) {
        opponentMovements = movements;
    }
}
