package lotto.enums;

public enum WinningStatistics {
    FIRST(6, 2000000000, 0),
    SECOND(5, 30000000, 0),
    THIRD(5, 1500000, 0),
    FOURTH(4, 50000, 0),
    FIFTH(3, 5000, 0);

    private final int matchCount;
    private final int prize;
    private int count;

    WinningStatistics(int matchCount, int prize, int count) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.count = count;
    }

    public int getMatchCount() {
        return this.matchCount;
    }

    public int getPrize() {
        return this.prize;
    }

    public int getCount() {
        return this.count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
