package ascii3d;

import GameMap.Local;
import asciiPanel.AsciiCharacterData;
import asciiPanel.Line;
import asciiPanel.TileTransformer;
import java.awt.Color;

public class Perspective {

    private int radius;
    //lets get the asciiPanel width, and cut it in half
    private static Perspective pers = new Perspective(Screen.getInstance().getAsciiPanelWidth() / 2);
    private LocationManager locManager;
    /*
     TEMP CODE
     */
    private AsciiCharacterData defaultData = new AsciiCharacterData('.', Color.WHITE, Color.BLUE);
    private int temp_ref = 0;
    //ENDE HERE

    public Perspective(int radius) {
        this.radius = radius;
        locManager = new LocationManager();
    }

    public Command lookRight() {
        locManager.turnRight();
        return new Command() {
            @Override
            public void exe(Controller c) {
                //we just turned to the right

            }
        };
    }

    public Command lookLeft() {
        locManager.turnLeft();
        return new Command() {
            @Override
            public void exe(Controller c) {
                //we just turned to the left

            }
        };
    }

    public Command step(Step s) {
        if (locManager.step(s)) {
            switch (s) {
                case FORWARD:
                    return new Command() {
                        @Override
                        public void exe(Controller c) {

                        }
                    };
                case BACK:
                    return new Command() {
                        @Override
                        public void exe(Controller c) {

                        }
                    };
                case RIGHT:
                    return new Command() {
                        @Override
                        public void exe(Controller c) {
                        }
                    };
                case LEFT:
                    return new Command() {
                        @Override
                        public void exe(Controller c) {
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
