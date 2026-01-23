package dev.jvictor.chess.core;

public class Position {
    public int x, y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Position fromString(String position) {
        int x = position.charAt(0) - 96; 
        int y = Integer.parseInt(position.substring(1), 10); 
        return new Position(x, y);
    }
}
