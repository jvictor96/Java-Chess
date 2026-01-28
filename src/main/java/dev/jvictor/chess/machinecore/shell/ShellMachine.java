package dev.jvictor.chess.machinecore.shell;

import java.util.Map;

import dev.jvictor.chess.machinecore.ports.ShellStateHandler;
import dev.jvictor.chess.machinecore.ports.ShellStateHandler.ShellState;

public class ShellMachine {
    Map<ShellState, ShellStateHandler> handlers;
    ShellState state;

    public ShellMachine(Map<ShellState, ShellStateHandler> handlers) {
        this.handlers = handlers;
    }

    public void mainLoop() {
        while (true) {
            state = handlers.get(state).handle();
        }
    }
}
