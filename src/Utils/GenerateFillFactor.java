package utils;

public final class GenerateFillFactor {
    public GenerateFillFactor() {
    }

    public static int generate(int height, int weight, double fillFactor) {
        return (int) Math.round(height * weight * fillFactor);
    }
}
