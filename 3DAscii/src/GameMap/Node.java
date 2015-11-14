package GameMap;

public class Node {
    //this class should hold any specific details about the rooms/halls

    private int xSize, ySize;
    private Direction[] doors = new Direction[4];

    public Node(int xs, int ys) {
        this.xSize = xs;
        this.ySize = ys;
    }

    public int getXSize() {
        return xSize;
    }

    public int getYSize() {
        return ySize;
    }

    public Direction[] getDoors() {
        return doors;
    }

}
