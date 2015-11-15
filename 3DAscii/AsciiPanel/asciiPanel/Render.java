package asciiPanel;

import java.awt.Point;

public class Render {

    private final int x, y;
    private final AsciiCharacterData charData;

    public Render(int x, int y, AsciiCharacterData d) {
        charData = d;
        this.x = x;
        this.y = y;
    }

    public Render(Point p, AsciiCharacterData d) {
        this(p.x, p.y, d);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public AsciiCharacterData getAsciiCharacterData() {
        return charData;
    }
}
