package asciiPanel;

import java.awt.Point;
import java.util.LinkedList;
import java.util.List;

public class Line {

    private Point start, end;
    private Render[] render;

    public Line(Point p1, Point p2, AsciiCharacterData[] d) {
        start = p1;
        end = p2;
        //we really want this to not happen
        if (d.length < width()) {
            throw new IllegalArgumentException("ascii data array is too short for the line lenght!");
        }
        render = fillRender(d);
    }

    public Line(Point p1, Point p2, AsciiCharacterData d) {
        start = p1;
        end = p2;
        render = fillRender(d);
    }

    /*
     we're using Bresenham's line algorithm:
     */
    private Render[] fillRender(AsciiCharacterData data) {
        List<Render> temp = new LinkedList<>();
        int dx = end.x - start.x;
        int dy = end.y - start.y;

        int dif = 2 * dy - dx; // using '2 *()' to eliminate a 1/2 in original formula
        temp.add(new Render(start.x, start.y, data));
        int y = start.y;
        int x = start.x;
        for (int i = 1; i < end.x + 1; i++) {
            temp.add(new Render(i, y, data));
            dif = dif + (2 * dy);
            if (dif > 0) {
                y = y + 1;
                dif = dif - (2 * dx);
            }
        }
        return (Render[]) temp.toArray(new Render[temp.size()]);
    }

    private Render[] fillRender(AsciiCharacterData data[]) {
        List<Render> temp = new LinkedList<>();
        int dx = end.x - start.x;
        int dy = end.y - start.y;

        int dif = 2 * dy - dx; // using '2 *()' to eliminate a 1/2 in original formula
        temp.add(new Render(start.x, start.y, data[0]));
        int y = start.y;
        int x = start.x;
        for (int i = 1; i < end.x + 1; i++) {
            temp.add(new Render(i, y, data[i]));
            dif = dif + (2 * dy);
            if (dif > 0) {
                y = y + 1;
                dif = dif - (2 * dx);
            }
        }
        return (Render[]) temp.toArray(new Render[temp.size()]);
    }

    public final int width() {
        //we're always going to be using
        //the side of the line with no overlaps as width,
        //here it is the x val bc we use x to increment in the bresen alg
        if (start.x == end.x) {
            return 1;
        }
        return Math.abs(end.x - start.x) + 1;
    }

    public final int height() {
        if (start.y == end.y) {
            return 1;
        }
        return Math.abs(end.y - start.y) + 1;
    }

    public Render[] getRender() {
        return render;
    }

    public int getStartX() {
        return start.x;
    }

    public int getStartY() {
        return start.y;
    }

    public int getEndX() {
        return end.x;
    }

    public int getEndY() {
        return end.y;
    }

    public Point getStart() {
        return start;
    }

    public Point getEnd() {
        return end;
    }

    @Override
    public String toString() {
        String temp = "";
        for (Render r : render) {
            if (r != null) {
                temp += r.getAsciiCharacterData().character;
            }
        }
        return start.toString() + " to " + end.toString() + " with data '" + temp + "'";
    }

}
