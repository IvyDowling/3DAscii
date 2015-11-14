package ascii3d;

public class PlayerCompass {

    private int degree;
    private final int increment;

    public PlayerCompass(int incr) {
        increment = incr;
    }

    public int getDegree() {
        return degree;
    }

    public int getIncrement() {
        return increment;
    }

    public void setDegree(int d) {
        if (d < 360) {
            degree = increment * (d / increment);
        }
    }
}
