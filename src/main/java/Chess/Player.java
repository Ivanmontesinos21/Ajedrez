package Chess;

public class Player {
    public enum Color {
        WHITE,
        BLACK
    }

    private final String name;
    private final Color color;

    public Player(String name, Color color) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }
}

