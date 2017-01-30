package ParserArgs;

public class StoreDataSector {
    private int height;
    private int width;
    private double fillFactor;

    public StoreDataSector() {
    }

    public StoreDataSector(int height, int width, double fillFactor) {
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

    public String printDemand() {
        return "Enter: -h value -w value -f value\n" +
                "h - height(integer), w - width(integer), f - fill factor(floating point)";
    }
}
