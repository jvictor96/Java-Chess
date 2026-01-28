package dev.jvictor.chess.machinecore.shell;

import dev.jvictor.chess.machinecore.players.YourHandler;
import dev.jvictor.chess.bootstrap.ports.Keyboard;
import dev.jvictor.chess.machinecore.ports.ShellStateHandler;

public class MoveCommand implements ShellStateHandler {

    Keyboard keyboard;
    YourHandler yourHandler;

    public MoveCommand(Keyboard keyboard) {
        this.keyboard = keyboard;
    }

    @Override
    public ShellState handle() {
        String movement = keyboard.read("Which movement(ex. e2e4)? ");
        yourHandler.appendMovement(movement);
        return ShellState.READING;
    }
    
}
