package GameMap;

public class Door {

    private int loc;
    private Direction direction;

    public Door(int x, Direction d) {
        loc = x;
        direction = d;
    }

    public Direction getDirection() {
        return direction;
    }

    public int getLocation() {
        return loc;
    }

    @Override
    public String toString() {
        return "door at" + loc + " in room on the " + direction + " side";
    }
}
