package dev.jvictor.chess.machinecore.players;

import java.util.List;

import dev.jvictor.chess.bootstrap.ports.PersistenceAdapter;
import dev.jvictor.chess.core.Board;
import dev.jvictor.chess.machinecore.ports.MessageCrossing;
import dev.jvictor.chess.machinecore.ports.MovementStateHandler;

public class OpponentHandler implements MovementStateHandler{

    MessageCrossing messageCrossing;
    PersistenceAdapter persistenceAdapter;
    int id;

    public OpponentHandler(List<String> movements, MessageCrossing messageCrossing, PersistenceAdapter persistenceAdapter, int id) {
        this.id = id;
        this.messageCrossing = messageCrossing;
        this.persistenceAdapter = persistenceAdapter;
    }

    @Override
    public MovementState handle() {
        return messageCrossing.pop()
            .map(movement -> {
                Board board = persistenceAdapter.getBoard(id);
                board.move(board.buildMovement(movement));
                persistenceAdapter.saveBoard(id, board);
                return board.legal ? MovementState.THEIR_TURN : MovementState.YOUR_TURN;
            })
            .orElse(MovementState.YOUR_TURN);
    }
    
    public void sendMovement(String movement) {
        messageCrossing.send(movement);
    }
    
}
