package ascii3d;

import GameMap.Direction;
import GameMap.Local;
import asciiPanel.AsciiCharacterData;
import asciiPanel.Drawable;
import asciiPanel.Line;
import java.awt.Color;
import java.awt.Point;

public class LocationManager {

    private PlayerCompass pCompass;
    private Local localMap;
    private Point currentLocation;

    public LocationManager() {
        pCompass = new PlayerCompass(Screen.getInstance().getAsciiPanelHeight() / 2);
        localMap = new Local();
        currentLocation = new Point();
    }

    public void turnRight() {
        pCompass.increment();
    }

    public void turnLeft() {
        pCompass.decrement();
    }

    public Drawable[] getView() {
        Drawable[] view = new Drawable[]{
            new Line(new Point(0, 0), new Point(100, 39), new AsciiCharacterData('\\', Color.WHITE, Color.BLACK)),
            new Line(new Point(0, 39), new Point(100, 0), new AsciiCharacterData('/', Color.WHITE, Color.BLACK))
        };
        return view;
    }

    public boolean step(Step s) { //return if can step
        //first we're going to get our relative facing direction
        Direction facing = this.netDirection(pCompass.getDegree());
        //so lets see what our relative direction will be
        switch (s) {
            case FORWARD:
                //we're using the same direction then!
                break;
            case BACK:
                facing = facing.set180();
                break;
            case LEFT:
                facing = facing.set180().set90();
                break;
            case RIGHT:
                facing = facing.set90();
                break;
        }
        //now, with our intented direction found
        //we can figure out if we can manage that on the map
        //rooms are defined by their bottom left corner
        switch (facing) {
            case NORTH:
                if (currentLocation.y + 1 < localMap.getCurrentNode().getYSize()) {
                    currentLocation.y = currentLocation.y + 1;
                    return true;
                }
                return false;
            case EAST:
                if (currentLocation.x + 1 < localMap.getCurrentNode().getXSize()) {
                    currentLocation.x = currentLocation.x + 1;
                    return true;
                }
                return false;
            case SOUTH:
                if (currentLocation.y - 1 > 0) {
                    currentLocation.y = currentLocation.y - 1;
                    return true;
                }
                return false;
            case WEST:
                if (currentLocation.x + 1 > 0) {
                    currentLocation.x = currentLocation.x - 1;
                    return true;
                }
                return false;
        }
        return false;
    }

    private Direction netDirection(int deg) {
        if (deg > 314 || deg < 45) {
            return Direction.NORTH;
        }
        if (deg > 44 && deg < 135) {
            return Direction.EAST;
        }
        if (deg > 134 && deg < 225) {
            return Direction.SOUTH;
        }
        //deg > 224 && deg < 315
        return Direction.WEST;
    }

    public int getDirectionFacing() {
        return pCompass.getDegree();
    }
}
