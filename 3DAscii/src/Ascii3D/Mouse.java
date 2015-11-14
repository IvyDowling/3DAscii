package ascii3d;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Mouse implements MouseMotionListener, MouseListener {

    private int x1, x2;
    private final int MOUSE_DIF = 30; //pixels
    private static Controller controller;

    public Mouse() {
        controller = Controller.getInstance();
    }

    @Override
    public void mouseDragged(MouseEvent me) {
    }

    @Override
    public void mouseMoved(MouseEvent me) {
        controller.takeMouseMotion(me.getX());
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        controller.takeMouseClick(me.getX(), me.getY());
    }

    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }

}
