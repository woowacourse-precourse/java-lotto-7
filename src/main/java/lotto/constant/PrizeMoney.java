package lotto.constant;

public enum PrizeMoney {
    FIRST_PRIZE(2_000_000_000L, 0),
    SECOND_PRIZE(30_000_000L, 0),
    THIRD_PRIZE(1_500_000L, 0),
    FORTH_PRIZE(50_000L, 0),
    FIFTH_PRIZE(5_000L, 0);

    private long prize;
    private int count;

    PrizeMoney(long prize, int count) {
        this.prize = prize;
        this.count = count;
    }

    public long getPrize() {
        return prize;
    }

    public int getCount() {
        return count;
    }

    public void incrementCount() {
        this.count++;
    }
}
