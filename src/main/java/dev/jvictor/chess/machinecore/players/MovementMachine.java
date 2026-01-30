package dev.jvictor.chess.machinecore.players;

import java.util.Map;

import dev.jvictor.chess.io.InMemoryMessageCrossing;
import dev.jvictor.chess.machinecore.ports.MovementStateHandler;
import dev.jvictor.chess.machinecore.ports.MovementStateHandler.MovementState;

public class MovementMachine {

    Map<MovementState, MovementStateHandler> handlers;

    public MovementMachine(Map<MovementState, MovementStateHandler> handlers) {
        this.handlers = handlers;
    }

    public boolean mainLoop(MovementState state) {
        InMemoryMessageCrossing messageCrossing = (InMemoryMessageCrossing) ((YourHandler) handlers.get(MovementState.YOUR_TURN)).messageCrossing;
        while (true) {
            state = handlers.get(state).handle();
            try {
                Thread.sleep(200);
                if(messageCrossing.messages.size() == 0) {
                    return true;
                }
            } catch (InterruptedException e) {// It's actually expected to be interrupted
            }
        }
    }
}
