package dev.jvictor.chess.machinecore.shell;

import java.util.Map;
import java.util.Optional;

import dev.jvictor.chess.bootstrap.ports.Keyboard;
import dev.jvictor.chess.machinecore.ports.ShellStateHandler;

public class CommandReader implements ShellStateHandler {

    Keyboard keyboard;

    public CommandReader(Keyboard keyboard) {
        this.keyboard = keyboard;
    }

    @Override
    public ShellState handle() {
        String reading = keyboard.read("type move to make a movement in the present game, or 'list games', 'change game', 'resign', 'new game'");
        return Optional.of(Map.of(
            "move", ShellState.MOVING,
            "list games", ShellState.LISTING,
            "change game", ShellState.CHANGING,
            "resign", ShellState.RESIGNING,
            "new game", ShellState.CHALLENGING
        ).get(reading)).orElse(ShellState.READING);
    }
}
