package ascii3d;

import asciiPanel.AsciiCharacterData;
import asciiPanel.Render;
import java.awt.Color;
import java.util.Random;

public class Ghost {

    private Random r;
    private Color mix;

    public Ghost() {
        r = new Random();
    }

    public Ghost(Color mix) {
        r = new Random();
        this.mix = mix;
    }

    public Render[] getGhostImage(int x, int y) {
        Render[] ghost = new Render[r.nextInt(20)];
        if (mix == null) {
            for (int i = 0; i < ghost.length; i++) {
                ghost[i] = new Render(x + (r.nextInt(10) - 5),
                        y + (r.nextInt(10) - 5),
                        new AsciiCharacterData((char) r.nextInt(255),
                                new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)),
                                new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255))));
            }
        } else {
            for (int i = 0; i < ghost.length; i++) {
                int red = r.nextInt(256);
                int green = r.nextInt(256);
                int blue = r.nextInt(256);
                int redbg = r.nextInt(256);
                int greenbg = r.nextInt(256);
                int bluebg = r.nextInt(256);

                // mix the color
                if (mix != null) {
                    red = (red + mix.getRed()) / 2;
                    green = (green + mix.getGreen()) / 2;
                    blue = (blue + mix.getBlue()) / 2;
                    redbg = (red + mix.getRed()) / 2;
                    greenbg = (green + mix.getGreen()) / 2;
                    bluebg = (blue + mix.getBlue()) / 2;
                }
                ghost[i] = new Render(x + (r.nextInt(10) - 5),
                        y + (r.nextInt(10) - 5),
                        new AsciiCharacterData((char) r.nextInt(255),
                                new Color(red, green, blue),
                                new Color(redbg, greenbg, bluebg)));
            }
        }

        return ghost;
    }
}
