package ascii3d;

import GameMap.LocalList;

public class Perspective {

    private LocalList local;
    private Layer[] layer;
    private int radius;
    //lets get the asciiPanel width, and cut it in half
    private static Perspective pers = new Perspective(Screen.getInstance().getAsciiPanelWidth() / 2);
    private PlayerCompass pc;

    public Perspective(int radius) {
        local = new LocalList(30, 5);
        layer = new Layer[radius];
        this.radius = radius;
        pc = new PlayerCompass(Screen.getInstance().getAsciiPanelHeight() / 2);
    }

    public Command lookRight() {
        System.out.println("Right");
        return new Command() {
            @Override
            public void exe(Controller c) {
                c.render();
            }
        };
    }

    public Command lookLeft() {
        System.out.println("Left");
        return new Command() {
            @Override
            public void exe(Controller c) {
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
