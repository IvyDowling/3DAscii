package ascii3d;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Listener implements KeyListener {

    private int[] keys = {37, 38, 39, 40};
    private char[] characters = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    private char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
        'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    private int lastKeyPressed;
    private boolean enabled;
    private static Controller controller;

    public Listener() {
        controller = Controller.getInstance();
        enabled = true;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        controller.takeInput(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    public void Enable() {
        enabled = true;
    }

}
