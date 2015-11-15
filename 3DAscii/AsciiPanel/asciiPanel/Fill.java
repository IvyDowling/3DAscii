package asciiPanel;

import java.awt.Point;

public class Fill {

    private Render[] fill;

    public Fill(Point p1, Point p2, Point p3, Point p4) {
    }

    public Fill(Line l1, Line l2) {
    }

    public Fill(Render[] f) {
        fill = f;
    }

    public Render[] getFill() {
        return fill;
    }
}
