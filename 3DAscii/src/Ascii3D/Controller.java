package ascii3d;

public class Controller {

    private static Controller controller = new Controller();
    private static Screen screen;

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
