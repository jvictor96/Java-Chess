package dev.jvictor.chess.machinecore.shell;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import dev.jvictor.chess.bootstrap.ports.Keyboard;
import dev.jvictor.chess.machinecore.ports.ShellStateHandler;

public class CommandReader implements ShellStateHandler {

    Keyboard keyboard;
    List<String> messages;

    public CommandReader(Keyboard keyboard) {
        this.keyboard = keyboard;
    }

    @Override
    public ShellState handle() {
        String reading = messages.size() > 0 ? messages.removeFirst() : keyboard.read("type move to make a movement in the present game, or 'list games', 'change game', 'resign', 'new game'");
        return Optional.of(Map.of(
            "move", ShellState.MOVING,
            "list games", ShellState.LISTING,
            "change game", ShellState.CHANGING,
            "resign", ShellState.RESIGNING,
            "new game", ShellState.CHALLENGING
        ).get(reading)).orElse(ShellState.READING);
    }
    
    public void registerMessages(List<String> messages) {
        this.messages = messages;
    }
}
