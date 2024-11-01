package lotto.constant;

public enum WinningPrize {
    FIFTH_PRIZE(3, false, 5000),
    FOURTH_PRIZE(4, false, 50000),
    THIRD_PRIZE(5, false, 1500000),
    SECOND_PRIZE(5, true, 30000000),
    FIRST_PRIZE(6, false, 2000000000),

    NONE(0, false, 0);

    private final int matchingCount;
    private final boolean isBonusMatch;
    private final int prizeAmount;

    WinningPrize(int matchingCount, boolean isBonusMatch, int prizeAmount) {
        this.matchingCount = matchingCount;
        this.isBonusMatch = isBonusMatch;
        this.prizeAmount = prizeAmount;
    }

    public boolean isBonusMatch() {
        return isBonusMatch;
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }


}
