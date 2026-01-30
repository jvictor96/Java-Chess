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

import dev.jvictor.chess.bootstrap.ports.GameViewer;
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
    GameViewer gameViewer;
    Keyboard keyboard;
    String user;
    public CompletableFuture<?> game;
    public MessageCrossing messageCrossing;
    ExecutorService gameExecutor = Executors.newSingleThreadExecutor();

    public ChangeCommand(PersistenceAdapter persistenceAdapter, Keyboard keyboard, GameViewer gameViewer, List<String> movements, String user, MessageCrossingFactory messageCrossingFactory) {
        this.persistenceAdapter = persistenceAdapter;
        this.keyboard = keyboard;
        this.messageCrossingFactory = messageCrossingFactory;
        this.gameViewer = gameViewer;
        this.movements = movements;
        this.opponentMovements = new ArrayList<>();
        this.user = user;
        gameExecutor = Executors.newSingleThreadExecutor();
    }

    @Override
    public ShellState handle() {
        persistenceAdapter.listGames();
        int id = Integer.parseInt(keyboard.read("which game? ").strip());
        Board board = persistenceAdapter.getBoard(id).orElse(null);
        if (game != null && !game.isDone()) game.cancel(true);
        String opponent = board.white == user ? board.black : board.white;
        messageCrossing = messageCrossingFactory.getMessageCrossing(user, opponent);
        boolean userTurn = List.of(board.movements.size() % 2 == 0, board.white == user).stream().allMatch(Boolean::booleanValue);
        MovementState state = userTurn ? MovementState.YOUR_TURN : MovementState.THEIR_TURN;
        messageCrossing.registerOpponentMessages(opponentMovements);
        MovementMachine movementMachine = new MovementMachine(Map.of(
            MovementState.YOUR_TURN, new YourHandler(movements, messageCrossing, persistenceAdapter, gameViewer, id),
            MovementState.THEIR_TURN, new OpponentHandler(movements, messageCrossing, persistenceAdapter, gameViewer, id)
        ));
        game = CompletableFuture.supplyAsync(() -> movementMachine.mainLoop(state), gameExecutor);
        return ShellState.READING;
    }
    
    public void registerOpponentMovements(List<String> movements) {
        opponentMovements = movements;
    }
}
