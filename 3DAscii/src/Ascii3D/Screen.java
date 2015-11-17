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
    private List<TileTransformer> transformList;

    public Screen() {
        this.setSize(DIMENSION);
        this.setBounds(0, 0, WIDTH * SCALE, HEIGHT * SCALE);
        this.add(asciiPanel = new AsciiPanel(WIDTH, HEIGHT));
        this.setBackground(Color.BLACK);

        renderList = new LinkedList<>();
        transformList = new LinkedList<>();
        asciiPanel.setBackground(Color.BLACK);
        asciiPanel.setForeground(Color.WHITE);
    }
    
    public void addAnimation(TileTransformer t){
        transformList.add(t);
    }
    
    public void addAnimation(TileTransformer[] t){
        for (TileTransformer tile : t) {
            this.addAnimation(tile);
        }
    }

    public void addRender(Render r) {
        renderList.add(r);
    }

    public void addRender(Render[] r) {
        for (Render rn : r) {
            this.addRender(rn);
        }
    }

    public void render() {
        Render[] tempRender = renderList.toArray(new Render[renderList.size()]);
        for (Render r : tempRender) {
            asciiPanel.write(r);
        }
        TileTransformer[] tempTransformer = transformList.toArray(new TileTransformer[transformList.size()]);
        transformList.clear();
        for(TileTransformer t: tempTransformer){
            asciiPanel.withEachTile(t);
        }
        this.repaint();
    }
    
    public void clearRenders(){
        renderList.clear();
        asciiPanel.clear();
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
}
