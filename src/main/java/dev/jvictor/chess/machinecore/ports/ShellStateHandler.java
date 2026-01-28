package dev.jvictor.chess.machinecore.ports;

public interface ShellStateHandler {
    
    public enum ShellState{
        READING, LISTING, CHANGING, CHALLENGING, MOVING, RESIGNING
    }

    public abstract ShellState handle();

}
