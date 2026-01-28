package dev.jvictor.chess.machinecore.players;

import java.util.Map;

import dev.jvictor.chess.machinecore.ports.MovementStateHandler;
import dev.jvictor.chess.machinecore.ports.MovementStateHandler.MovementState;

public class MovementMachine {

    Map<MovementState, MovementStateHandler> handlers;
    MovementState state;

    public MovementMachine(Map<MovementState, MovementStateHandler> handlers) {
        this.handlers = handlers;
    }

    public boolean mainLoop() {
        while (true) {
            state = handlers.get(state).handle();
        }
    }
}
