package dev.jvictor.chess.machinecore.ports;

import java.util.List;
import java.util.Optional;

public interface MessageCrossing {
    public abstract Optional<String> pop();
    public abstract void send(String move);
    public abstract void registerOpponentMessages(List<String> messages);
}
