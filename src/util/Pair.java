package util;

public class Pair {
    private final int x;
    private final int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // hard coded values so values align with mouse pointer
    public int getX() {
        return x - 6;
    }

    // hard coded values so values align with mouse pointer
    public int getY() {
        return y - 67;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
