package ascii3d;

public class Controller {

    private static Controller controller = new Controller();
    private static Screen screen;
    private static Perspective pers;
    private int xInst;
    private final int xDiff;

    public Controller() {
        screen = Screen.getInstance();
        pers = Perspective.getInstance();

        //number of pixels per registered turn
        xDiff = 16;
    }

    public void render() {
        screen.render();
    }

    public void addRender() {
        
    }

    private void execute(Command c) {
        if (c != null) {
            c.exe(getInstance());
        }
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
            case 37://left
                break;
            case 38://up
                break;
            case 39://right
                break;
            case 40://down
                break;
        }
    }

    public static Controller getInstance() {
        if (controller == null) {
            Controller controller = new Controller();
        }
        return controller;
    }
}
