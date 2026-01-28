package dev.jvictor.chess.machinecore.ports;

public interface MessageCrossingFactory {
    public MessageCrossing getMessageCrossing(String user, String opponent);
    
}
