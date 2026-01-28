package dev.jvictor.chess.io;

import java.util.ArrayList;
import java.util.List;

import dev.jvictor.chess.bootstrap.ports.Keyboard;;

public class InMemoryKeyboard implements Keyboard {

    private List<String> entries = new ArrayList<>();

    @Override
    public String read(String prompt) {
        // TODO Auto-generated method stub
        return entries.size() > 0 ? entries.removeFirst() : null;
    }

    @Override
    public void putEntry(String entry) {
        entries.add(entry);
    }
    
}
