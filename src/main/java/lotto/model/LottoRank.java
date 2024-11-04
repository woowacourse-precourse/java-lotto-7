package lotto.model;

public enum LottoRank {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000);

    private final int matchNumbers;
    private final boolean matchBonusNumber;
    private final int prizeAmount;

    LottoRank(int matchNumbers, boolean matchBonusNumber, int prizeAmount) {
        this.matchNumbers = matchNumbers;
        this.matchBonusNumber = matchBonusNumber;
        this.prizeAmount = prizeAmount;
    }

    public int getMatchNumbers() {
        return matchNumbers;
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }
}
