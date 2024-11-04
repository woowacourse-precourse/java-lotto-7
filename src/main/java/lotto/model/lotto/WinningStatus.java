package lotto.model.lotto;

public enum WinningStatus {
    FIRST_PRIZE(2000000000, 6),
    SECOND_PRIZE(30000000, 5),
    THIRD_PRIZE(1500000, 5),
    FOURTH_PRIZE(50000, 4),
    FIFTH_PRIZE(5000, 3);

    private final int prizeAmount;
    private final int matchCount;

    WinningStatus(int prizeAmount, int matchCount) {
        this.prizeAmount = prizeAmount;
        this.matchCount = matchCount;
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }

    public int getMatchCount() {
        return matchCount;
    }
}
