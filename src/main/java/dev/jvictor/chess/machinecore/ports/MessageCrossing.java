package dev.jvictor.chess.machinecore.ports;

import java.util.Optional;

public interface MessageCrossing {
    public abstract Optional<String> pop();
    public abstract void send(String move);
}
