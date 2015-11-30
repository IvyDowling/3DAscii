package ascii3d;

import asciiPanel.Drawable;
import asciiPanel.TileTransformer;

public class Controller {

    private static Controller controller = new Controller();
    private static Screen screen;
    private static Perspective pers;
    private int xInst;
    private final int xDiff;

    public Controller() {
        screen = Screen.getInstance();
        pers = Perspective.getInstance();
        //number of pixels per registered turn for mouse reg
        xDiff = 16;
    }

    public void render() {
        screen.render();
    }

    public void addAnimation(TileTransformer t) {
        screen.addAnimation(t);
    }

    public void addAnimation(TileTransformer[] t) {
        screen.addAnimation(t);
    }

    public void addDraw(Drawable[] r) {
        screen.addDraw(r);
    }

    public void addDraw(Drawable r) {
        screen.addDraw(r);
    }

    private void execute(Command c) {
        if (c != null) {
            c.exe(getInstance());
        }
    }

    public void clearRenders() {
        screen.clearRenders();
    }

    public void setMouseValue(int x) {
        xInst = x;
    }

    public void takeMouseMotion(int x) {
        if (x - xDiff > xInst) {
            //move right
            execute(pers.lookRight());
            xInst = x;
        } else if (x + xDiff < xInst) {
            //move left
            execute(pers.lookLeft());
            xInst = x;
        }
        //nothing happening!
    }

    public void takeMouseClick(int x, int y) {
        
    }

    public void takeInput(int keyCode) {
        switch (keyCode) {
            case 65://a
            case 37://left
                execute(pers.step(Step.LEFT));
                break;
            case 87://w
            case 38://up
                execute(pers.step(Step.FORWARD));
                break;
            case 68://d
            case 39://right
                execute(pers.step(Step.RIGHT));
                break;
            case 83://s
            case 40://down
                execute(pers.step(Step.BACK));
                break;
        }
    }

    public int getScreenWidth() {
        return screen.getAsciiPanelWidth();
    }

    public int getScreenHeight() {
        return screen.getAsciiPanelHeight();
    }

    public static Controller getInstance() {
        if (controller == null) {
            Controller controller = new Controller();
        }
        return controller;
    }
}
