package ascii3d;

import asciiPanel.AsciiCharacterData;
import asciiPanel.Render;
import java.awt.Color;
import java.util.Random;

public class Ghost {

    private Random r;

    public Ghost() {
        r = new Random();
    }

    public Render[] getGhostImage(int x, int y) {
        Render[] ghost = new Render[r.nextInt(20)];
        for (int i = 0; i < ghost.length; i++) {
            ghost[i] = new Render(x + (r.nextInt(10) - 5),
                    y + (r.nextInt(10) - 5),
                    new AsciiCharacterData((char) r.nextInt(255),
                            new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)),
                            new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255))));
        }
        return ghost;
    }
}
