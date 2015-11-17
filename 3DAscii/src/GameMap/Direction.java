package GameMap;

public enum Direction {

    NORTH, SOUTH, EAST, WEST;

    public Direction set180() {
        if (this == NORTH) {
            return SOUTH;
        }
        if (this == SOUTH) {
            return NORTH;
        }
        if (this == EAST) {
            return WEST;
        }
        if (this == WEST) {
            return EAST;
        }
        return null;
    }
    
    public Direction set90(){
        if (this == NORTH) {
            return EAST;
        }
        if (this == EAST) {
            return SOUTH;
        }
        if (this == SOUTH) {
            return WEST;
        }
        if (this == WEST) {
            return NORTH;
        }
        return null;
    }
}
