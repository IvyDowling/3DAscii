package ascii3d;

import GameMap.LocalList;
import asciiPanel.AsciiCharacterData;
import asciiPanel.Line;
import java.awt.Color;
import java.awt.Point;

public class Perspective {

    private LocalList local;
    private Layer[] layer;
    private int radius;
    //lets get the asciiPanel width, and cut it in half
    private static Perspective pers = new Perspective(Screen.getInstance().getAsciiPanelWidth() / 2);
    private PlayerCompass pc;

    /*
     TEMP CODE
     */
    private AsciiCharacterData defaultData = new AsciiCharacterData('.', Color.WHITE, Color.BLUE);
    private int temp_ref = 0;
    //ENDE HERE

    public Perspective(int radius) {
        local = new LocalList(30, 5);
        layer = new Layer[radius];
        this.radius = radius;
        pc = new PlayerCompass(Screen.getInstance().getAsciiPanelHeight() / 2);
    }

    public Command lookRight() {
        temp_ref--;
        if (temp_ref < 0) {
            temp_ref = 0;
        }
        return new Command() {
            @Override
            public void exe(Controller c) {
                c.clearRenders();
                c.addRender(new Line(new Point(1, 1), new Point(60, temp_ref), defaultData).getRender());
            }
        };
    }

    public Command lookLeft() {
        temp_ref++;
        if (temp_ref > 30) {
            temp_ref = 30;
        }
        return new Command() {
            @Override
            public void exe(Controller c) {
                c.clearRenders();
                c.addRender(new Line(new Point(1, 1), new Point(60, temp_ref), defaultData).getRender());
//                System.out.println(new Line(new Point(0, 0), new Point(4, 4),defaultData).toString());
            }
        };
    }

    public Command update(int keyCode) {
        switch (keyCode) {
            case 37://left
                return new Command() {
                    @Override
                    public void exe(Controller c) {
                    }
                };
            case 38://up
                return new Command() {
                    @Override
                    public void exe(Controller c) {
                    }
                };
            case 39://right
                return new Command() {
                    @Override
                    public void exe(Controller c) {
                    }
                };
            case 40://down
                return new Command() {
                    @Override
                    public void exe(Controller c) {
                    }
                };
        }
        //do nothing
        return new Command() {
            @Override
            public void exe(Controller c) {
            }
        };
    }

    public Layer getLayer(int r) {
        return layer[r];
    }

    public static Perspective getInstance() {
        if (pers == null) {
            pers = new Perspective(Screen.getInstance().getAsciiPanelWidth() / 2);
        }
        return pers;
    }
}
