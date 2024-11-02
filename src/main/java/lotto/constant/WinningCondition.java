package lotto.constant;

public enum WinningCondition {
    MATCH_3(3, false, 5_000),
    MATCH_4(4, false, 50_000),
    MATCH_5(5, false, 1_500_000),
    MATCH_5_BONUS(5, true, 30_000_000),
    MATCH_6(6, false, 2_000_000_000);

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isBonusMatch() {
        return bonusMatch;
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }

    public String PrizeAmountToString() {
        String amount = String.valueOf(prizeAmount);
        amount.replace("_", ",");
        return amount;
    }

    private final int matchCount;
    private final boolean bonusMatch;
    private final int prizeAmount;

    WinningCondition(int matchCount, boolean bonusMatch, int prizeAmount) {
        this.matchCount = matchCount;
        this.bonusMatch = bonusMatch;
        this.prizeAmount = prizeAmount;
    }
}
