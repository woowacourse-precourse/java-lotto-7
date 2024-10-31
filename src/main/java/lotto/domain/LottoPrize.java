package lotto.domain;

public enum LottoPrize {
    FIRST(6, 2000000000),
    THIRD(5, 30000000),
    SECOND(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    NONE(0, 0);

    private final int match;
    private final long prize;

    private int count;

    LottoPrize(int match, long prize) {
        this.match = match;
        this.prize = prize;
    }

    public static long getPrizeByRank(int match) {
        for (LottoPrize value : values()) {
            if (value.getMatch() == match) {
                value.incrementCount();
                return value.prize;
            }
        }
        return NONE.prize;
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
}
    