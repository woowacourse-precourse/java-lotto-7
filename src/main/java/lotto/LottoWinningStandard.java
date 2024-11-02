package lotto;

public enum LottoWinningStandard {
    FIRST_PRIZE(6, 0, 2000000000),
    SECOND_PRIZE(5, 1, 30000000),
    THIRD_PRIZE(5, 0, 1500000),
    FOURTH_PRIZE(4, 0, 50000),
    FIFTH_PRIZE(3, 0, 5000);

    private final int matchedNumberCount;
    private final int matchedBonusNumberCount;
    private final int prizeMoney;

    LottoWinningStandard(int matchedNumberCount, int matchedBonusNumberCount, int prizeMoney) {
        this.matchedNumberCount = matchedNumberCount;
        this.matchedBonusNumberCount = matchedBonusNumberCount;
        this.prizeMoney = prizeMoney;
    }

    public int getMatchedNumberCount() {
        return matchedNumberCount;
    }

    public int getMatchedBonusNumberCount() {
        return matchedBonusNumberCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
}
