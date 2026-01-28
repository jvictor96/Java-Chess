package dev.jvictor.chess.machinecore.ports;

public interface MovementStateHandler {

    public enum MovementState{
        YOUR_TURN, THEIR_TURN
    }

    public abstract MovementState handle();
    
}
