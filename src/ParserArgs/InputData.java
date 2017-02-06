package parserArgs;

public class InputData {
    private int height;
    private int width;
    private double fillFactor;

    public InputData() {
    }

    public InputData(int height, int width, double fillFactor) {
        this.height = height;
        this.width = width;
        this.fillFactor = fillFactor;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public double getFillFactor() {
        return fillFactor;
    }
}
