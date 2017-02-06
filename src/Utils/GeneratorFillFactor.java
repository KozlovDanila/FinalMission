package utils;

public final class GeneratorFillFactor {
    public GeneratorFillFactor() {
    }

    public static int generate(int height, int weight, double fillFactor) {
        return (int) Math.round(height * weight * fillFactor);
    }
}
