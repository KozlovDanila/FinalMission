package ranking;

public enum Group {
    NONE(2),
    MINOR(4),
    NORMAL(7),
    MAJOR(13),
    CRITICAL(100);

    int maxSize;

    Group(int maxSize) {
        this.maxSize = maxSize;
    }

    public int getMaxSize() {
        return maxSize;
    }
}
