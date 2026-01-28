package dev.jvictor.chess.bootstrap.ports;

public interface Keyboard {
    public abstract String read(String prompt);
    public abstract void putEntry(String entry);
}
