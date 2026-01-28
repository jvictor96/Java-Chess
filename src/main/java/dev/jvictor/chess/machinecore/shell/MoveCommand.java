package dev.jvictor.chess.machinecore.shell;

import java.util.List;

import dev.jvictor.chess.bootstrap.ports.Keyboard;
import dev.jvictor.chess.machinecore.ports.ShellStateHandler;

public class MoveCommand implements ShellStateHandler {

    Keyboard keyboard;
    List<String> movements;

    public MoveCommand(Keyboard keyboard,  List<String> movements) {
        this.keyboard = keyboard;
        this.movements = movements;
    }

    @Override
    public ShellState handle() {
        String movement = keyboard.read("Which movement(ex. e2e4)? ");
        movements.add(movement);
        return ShellState.READING;
    }
    
}
