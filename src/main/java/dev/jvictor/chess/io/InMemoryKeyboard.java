package dev.jvictor.chess.io;

import java.util.ArrayList;
import java.util.List;

import dev.jvictor.chess.bootstrap.ports.Keyboard;;

public class InMemoryKeyboard implements Keyboard {

    public List<String> entries = new ArrayList<>();

    @Override
    public String read(String prompt) {
        return entries.size() > 0 ? entries.remove(0) : null;
    }

    @Override
    public void putEntry(String entry) {
        entries.add(entry);
    }

    public void clear() {
        entries = new ArrayList<>();
    }
    
}
