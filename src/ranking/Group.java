package ranking;

public enum Group {
    NONE(0, 2),
    MINOR(0, 4),
    NORMAL(0, 7),
    MAJOR(0, 13),
    CRITICAL(0, 100);

    private int count;
    private int maxCountForGroup;

    Group(int count, int maxCountForGroup) {
        this.count = count;
        this.maxCountForGroup = maxCountForGroup;
    }

    public void increaseCount() {
        count++;
    }

    public int getCount() {
        return count;
    }

    public int getMaxCount() {
        return maxCountForGroup;
    }
}
