package ascii3d;

import asciiPanel.*;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;

public class Screen extends JPanel {

    private static final int HEIGHT = 41, WIDTH = 121, SCALE = 32;
    private static final Dimension DIMENSION = new Dimension(WIDTH * SCALE, HEIGHT * SCALE);
    private static final int STARTING_HEIGHT = 75, STARTING_WIDTH = 80;
    private static Screen screen = new Screen();
    private static AsciiPanel asciiPanel;

    public Screen() {

        this.setSize(DIMENSION);
        this.setBounds(0, 0, WIDTH * SCALE, HEIGHT * SCALE);
        this.add(asciiPanel = new AsciiPanel(WIDTH, HEIGHT));
        this.setBackground(Color.BLACK);
        asciiPanel.setBackground(Color.BLACK);
        asciiPanel.setForeground(Color.WHITE);
    }

    public void render() {
        asciiPanel.withEachTile(new TileTransformer() {
            @Override
            public void transformTile(int x, int y, AsciiCharacterData data) {
                Color c = data.backgroundColor;
                data.backgroundColor = data.foregroundColor;
                data.foregroundColor = c;
            }
        });
        this.repaint();
    }

    public static Screen getInstance() {
        if (screen == null) {
            Screen screen = new Screen();
        }
        return screen;
    }
}
