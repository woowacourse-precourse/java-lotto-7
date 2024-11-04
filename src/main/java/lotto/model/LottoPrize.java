package lotto.model;

public enum LottoPrize {
    FIFTH(3, 5000),
    FOURTH(4, 50000),
    THIRD(5, 1500000),
    SECOND(55, 30000000),
    FIRST(6, 2000000000);

    private final int match;
    private final long prize;
    private int count;

    LottoPrize(int match, long prize) {
        this.match = match;
        this.prize = prize;
    }

    public static long getPrizeByRank(int matchCount) {
        for (LottoPrize value : values()) {
            if (value.getMatch() == matchCount) {
                value.incrementCount();
                return value.prize;
            }
        }

        return 0;
    }

    public void incrementCount() {
        this.count++;
    }

    public int getMatch() {
        return match;
    }

    public long getPrize() {
        return prize;
    }

    public int getCount() {
        return count;
    }
}
    