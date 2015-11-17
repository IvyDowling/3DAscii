package ascii3d;

public class PlayerCompass {

    private int degree;
    private final int increment;

    public PlayerCompass(int incr) {
        increment = incr;
    }

    private void loopDegree() {
        degree = degree % 360;
    }

    public void increment() {
        degree = degree + increment;
        if (degree >= 360) {
            loopDegree();
        }
    }

    public void decrement() {
        degree = degree - increment;
        if (degree >= 360) {
            loopDegree();
        }
    }

    public int getDegree() {
        return degree;
    }

    public int getIncrement() {
        return increment;
    }

    public void setDegree(int d) {
        degree = increment * (d / increment);
        if (degree >= 360) {
            loopDegree();
        }
    }
}
