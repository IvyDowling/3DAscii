package asciiPanel;

import java.awt.Point;

public class Fill implements Drawable{

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

    @Override
    public Render[] getRender() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void transform(int x, int y, AsciiCharacterData d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
