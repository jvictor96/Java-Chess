package dev.jvictor.chess.io;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import dev.jvictor.chess.machinecore.ports.MessageCrossing;

public class InMemoryMessageCrossing implements MessageCrossing {

    List<String> messages = new ArrayList<>();

    @Override
    public Optional<String> pop() {
        return Optional.of(messages.size() > 0 ? messages.remove(0) : null);
    }

    @Override
    public void send(String move) {
        return;
    }

    public void registerOpponentMessages(List<String> messages) {
        this.messages = messages;
    }
    
}
