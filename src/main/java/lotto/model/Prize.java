package lotto.model;

public enum Prize {
    THREE(3, 5000L),
    FOUR(4, 50000L),
    FIVE(5, 1500000L),
    SIX(6, 2000000000L),
    BONUS(7, 30000000L);

    private final int matchCount;
    private final long prizeAmount;

    Prize(int matchCount, long prizeAmount) {
        this.matchCount = matchCount;
        this.prizeAmount = prizeAmount;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public long getPrizeAmount() {
        return prizeAmount;
    }
}
