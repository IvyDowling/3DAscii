package GameMap;

public class Node {
    //this class should hold any specific details about the rooms/halls

    private int xSize, ySize;
    private Door[] doors;

    public Node(int xs, int ys, Door[] drs) {
        this.xSize = xs;
        this.ySize = ys;
        doors = drs;
    }

    public int getXSize() {
        return xSize;
    }

    public int getYSize() {
        return ySize;
    }

    public Door[] getDoors() {
        return doors;
    }

    @Override
    public String toString() {
        String drs = "";
        for (Door d : doors) {
            drs += d.toString() + "\n";
        }
        return "x: " + this.getXSize() + ", y: " + this.getYSize() + "; doors: " + drs;
    }

    @Override
    public boolean equals(Object n) {
        if (n == null) {
            return false;
        }
        Node temp = (Node) n;
        return temp.getXSize() == this.getXSize()
                && temp.getYSize() == this.getYSize()
                && temp.getDoors() == this.getDoors();
    }
}
