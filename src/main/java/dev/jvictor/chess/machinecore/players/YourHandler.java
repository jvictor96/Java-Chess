package dev.jvictor.chess.machinecore.players;

import java.util.List;
import java.util.Optional;

import dev.jvictor.chess.bootstrap.ports.PersistenceAdapter;
import dev.jvictor.chess.core.Board;
import dev.jvictor.chess.machinecore.ports.MessageCrossing;
import dev.jvictor.chess.machinecore.ports.MovementStateHandler;

public class YourHandler implements MovementStateHandler {

    List<String> movements;
    MessageCrossing messageCrossing;
    PersistenceAdapter persistenceAdapter;
    int id;

    public YourHandler(List<String> movements, MessageCrossing messageCrossing, PersistenceAdapter persistenceAdapter, int id) {
        this.id = id;
        this.movements = movements;
        this.messageCrossing = messageCrossing;
        this.persistenceAdapter = persistenceAdapter;
    }

    @Override
    public MovementState handle() {
        return Optional.ofNullable(movements.size() > 0 ? movements.removeFirst() : null)
            .map(movement -> {
                Board board = persistenceAdapter.getBoard(id);
                board.move(board.buildMovement(movement));
                persistenceAdapter.saveBoard(id, board);
                if (board.legal) messageCrossing.send(movement);
                return board.legal ? MovementState.THEIR_TURN : MovementState.YOUR_TURN;
            })
            .orElse(MovementState.YOUR_TURN);
    }
    
    public void appendMovement(String movement) {
        movements.add(movement);
    }
}
