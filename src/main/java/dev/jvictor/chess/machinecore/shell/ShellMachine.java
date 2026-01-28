package dev.jvictor.chess.machinecore.shell;

import java.util.Map;

import dev.jvictor.chess.machinecore.ports.ShellStateHandler;
import dev.jvictor.chess.machinecore.ports.ShellStateHandler.ShellState;

public class ShellMachine {
    Map<ShellState, ShellStateHandler> handlers;
    ShellState state;
    ShellMode shellMode;

    public enum ShellMode {
        FOREVER, WHILE_THERE_ARE_MESSAGES
    }

    public ShellMachine(Map<ShellState, ShellStateHandler> handlers, ShellMode shellMode) {
        this.shellMode = shellMode;
        this.handlers = handlers;
    }

    public void mainLoop() {
        while (shellMode == ShellMode.FOREVER || ((CommandReader) handlers.get(ShellState.READING)).messages.size() > 0) {
            state = handlers.get(state).handle();
        }
    }
}
