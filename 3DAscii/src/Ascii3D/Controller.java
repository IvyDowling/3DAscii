package ascii3d;

import java.awt.Color;

public class Controller {

    private static Controller controller = new Controller();
    private static Screen screen;
    
    private int pers = 0;
    
    public void move(){
        pers++;
        screen.addRenderArray(ImageLib.getHallSample(Color.WHITE, Color.BLACK));
        screen.addRenderArray(ImageLib.getWall(pers, Color.WHITE, Color.BLACK));
    }

    public Controller() {
        screen = Screen.getInstance();
    }

    public void render() {
        screen.render();
    }

    public static Controller getInstance() {
        if (controller == null) {
            Controller controller = new Controller();
        }
        return controller;
    }
}
