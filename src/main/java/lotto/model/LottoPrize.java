package lotto.model;

public enum LottoPrize {
    FAIL(0, 0, "", 0),
    FIFTH_PRIZE(3, 0, "3개 일치 (5,000원)", 5000),
    FORTH_PRIZE(4, 0, "4개 일치 (50,000원)", 50000),
    THIRD_PRIZE(5, 0, "5개 일치 (1,500,000원)", 1500000),
    SECOND_PRIZE(5, 1, "5개 일치, 보너스 볼 일치 (30,000,000원)", 30000000),
    FIRST_PRIZE(6, 0, "6개 일치 (2,000,000,000원)", 2000000000);

    private final String PRIZE_SEPARATOR = " - ";
    private final String UNIT_COUNT = "개";

    private final int matchingWinningCount;
    private final int matchingBonusCount;
    private final String prizeDetails;
    private final long prizeAmounts;

    LottoPrize(int matchingWinningCount, int matchingBonusCount, String prizeDetails, long prizeAmounts) {
        this.matchingWinningCount = matchingWinningCount;
        this.matchingBonusCount = matchingBonusCount;
        this.prizeDetails = prizeDetails;
        this.prizeAmounts = prizeAmounts;
    }

    public int getMatchingWinningCount() {
        return matchingWinningCount;
    }

    public int getMatchingBonusCount() {
        return matchingBonusCount;
    }

    public String getPrizeDetails() {
        return prizeDetails;
    }

    public long getPrizeAmount() {
        return prizeAmounts;
    }

    public String getPrizeStatusMessage(int prizeCount) {
        return getPrizeDetails() + PRIZE_SEPARATOR + prizeCount + UNIT_COUNT;
    }
}
