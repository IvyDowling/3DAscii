package ascii3d;

import asciiPanel.*;
import java.awt.Color;
import java.awt.Dimension;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JPanel;

public class Screen extends JPanel {

    private static final int HEIGHT = 41, WIDTH = 121, SCALE = 32;
    private static final Dimension DIMENSION = new Dimension(WIDTH * SCALE, HEIGHT * SCALE);
    private static final int STARTING_HEIGHT = 75, STARTING_WIDTH = 80;
    private static Screen screen = new Screen();
    private static AsciiPanel asciiPanel;
    private List<Render> renderList;
    private List<Animation> animationList;

    public Screen() {
        this.setSize(DIMENSION);
        this.setBounds(0, 0, WIDTH * SCALE, HEIGHT * SCALE);
        this.add(asciiPanel = new AsciiPanel(WIDTH, HEIGHT));
        this.setBackground(Color.BLACK);

        renderList = new LinkedList<>();
        animationList = new LinkedList<>();
        asciiPanel.setBackground(Color.BLACK);
        asciiPanel.setForeground(Color.WHITE);
    }

    public void addRender(Render r) {
        renderList.add(r);
    }

    public void addRenderArray(Render[] r) {
        for (Render rn : r) {
            this.addRender(rn);
        }
    }

    public void render() {
        //write default renders
//        this.updateGameUI();
        //write added renders
        Render[] tempRender = new Render[renderList.size()];
        tempRender = renderList.toArray(tempRender);
        renderList.clear();
        for (Render r : tempRender) {
            asciiPanel.write(r);
        }

//        while () {
//            asciiPanel.withEachTile(a.x, a.y, a.width, 1, a.transform);
//        }
        this.repaint();
    }

    public static Screen getInstance() {
        if (screen == null) {
            Screen screen = new Screen();
        }
        return screen;
    }

    public int getAsciiPanelWidth() {
        return WIDTH;
    }

    public int getAsciiPanelHeight() {
        return HEIGHT;
    }

    private class Animation {

        public TileTransformer transform;
        public int x, y, width;

        public Animation(int x, int y, int w, TileTransformer t) {
            this.x = x;
            this.y = y;
            width = w;
            transform = t;
        }
    }
}
