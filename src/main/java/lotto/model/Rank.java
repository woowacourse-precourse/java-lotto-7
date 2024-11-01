package lotto.model;

public enum Rank {

    FIFTH_PLACE(3, false, 5_000),
    FOURTH_PLACE(4, false, 50_000),
    THIRD_PLACE(5, false, 1_500_000),
    SECOND_PLACE(5, true, 30_000_000),
    FIRST_PLACE(6, false, 2_000_000_000);

    private final int matchedNumberCount;
    private final boolean containsBonusNumber;
    private final int winningPrice;

    Rank(int matchingCount, boolean containsBonusNumber, int winningPrice) {
        this.matchedNumberCount = matchingCount;
        this.containsBonusNumber = containsBonusNumber;
        this.winningPrice = winningPrice;
    }

    public int getMatchedNumberCount() {
        return matchedNumberCount;
    }

    public boolean isContainsBonusNumber() {
        return containsBonusNumber;
    }

    public int getWinningPrice() {
        return winningPrice;
    }
}
