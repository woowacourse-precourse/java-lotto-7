package lotto.constant;

public enum PrizeMoney {
    FIRST_PRIZE(2_000_000_000L),
    SECOND_PRIZE(30_000_000L),
    THIRD_PRIZE(1_500_000L),
    FORTH_PRIZE(50_000L),
    FIFTH_PRIZE(5_000L);

    private long prize;

    PrizeMoney(long prize) {
        this.prize = prize;
    }

    public long getPrize() {
        return prize;
    }
}
