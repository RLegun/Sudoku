public class Game {
    private Field field;
    private Player player;

    public Game(Field field, Player player) {
        this.field = field;
        this.player = player;
    }

    public Field getField() {
        return field;
    }

    public Player getPlayer() {
        return player;
    }
}