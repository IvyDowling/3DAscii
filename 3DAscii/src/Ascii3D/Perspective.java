package ascii3d;

import asciiPanel.AsciiCharacterData;
import asciiPanel.Drawable;
import asciiPanel.TileTransformer;
import java.util.LinkedList;
import java.util.List;

public class Perspective {

    private int radius;
    //lets get the asciiPanel width, and cut it in half
    private static Perspective pers = new Perspective(Screen.getInstance().getAsciiPanelWidth() / 2);
    private LocationManager locManager;
    private List<Drawable> draws;

    public Perspective(int radius) {
        this.radius = radius;
        locManager = new LocationManager();
        draws = new LinkedList<>();
    }

    public Drawable[] getDraw() {
        return locManager.getView();
    }

    public Command lookRight() {
        locManager.turnRight();
        return new Command() {
            @Override
            public void exe(Controller c) {
                //redraw
                c.addDraw(locManager.getView());
            }
        };
    }

    public Command lookLeft() {
        locManager.turnLeft();
        return new Command() {
            @Override
            public void exe(Controller c) {
                //redraw
                c.addDraw(locManager.getView());
            }
        };
    }

    public Command step(Step s) {
        //for steps we should be able to use simple transforms
        if (locManager.step(s)) {
            switch (s) {
                case FORWARD:
                    return new Command() {
                        @Override
                        public void exe(Controller c) {
                            //zoom in
                            c.addDraw(locManager.getView());
                        }
                    };
                case BACK:
                    return new Command() {
                        @Override
                        public void exe(Controller c) {
                            //zoom out
                            c.addDraw(locManager.getView());
                        }
                    };
                case RIGHT:
                    return new Command() {
                        @Override
                        public void exe(Controller c) {
                            //slide left
                            c.addDraw(locManager.getView());
                        }
                    };
                case LEFT:
                    return new Command() {
                        @Override
                        public void exe(Controller c) {
                            //slide right
                            c.addDraw(locManager.getView());
                        }
                    };
            }
        }
        return new Command() {
            @Override
            public void exe(Controller c) {
            }
        };
    }

    public static Perspective getInstance() {
        if (pers == null) {
            pers = new Perspective(Screen.getInstance().getAsciiPanelWidth() / 2);
        }
        return pers;
    }
}
