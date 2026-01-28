package dev.jvictor.chess.io;

import java.util.Optional;

import dev.jvictor.chess.machinecore.ports.MessageCrossing;

public class InMemoryMessageCrossing implements MessageCrossing {

    @Override
    public Optional<String> pop() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'pop'");
    }

    @Override
    public void send(String move) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'send'");
    }
    
}
