package lotto;

public enum LotteryPrize {
    THREE_MATCH(3, "3개 일치", 5000),
    FOUR_MATCH(4, "4개 일치", 50000),
    FIVE_MATCH(5, "5개 일치", 1500000),
    FIVE_AND_BONUS_MATCH(5, "5개 일치, 보너스 볼 일치", 30000000),
    SIX_MATCH(6, "6개 일치", 2000000000);

    private final int matchCount;
    private final String description;
    private final int prizeAmount;

    LotteryPrize(int matchCount, String description, int prizeAmount) {
        this.matchCount = matchCount;
        this.description = description;
        this.prizeAmount = prizeAmount;
    }

    public String getDescription() {
        return this.description;
    }

    public int getPrizeAmount() {
        return this.prizeAmount;
    }

    public static LotteryPrize getPrizeByMatchCount(int matchCount, boolean correctBonus) {
        if (matchCount == 3) {
            return THREE_MATCH;
        }
        if (matchCount == 4) {
            return FOUR_MATCH;
        }
        if (matchCount == 5 && correctBonus) {
            return FIVE_AND_BONUS_MATCH;
        }
        if (matchCount == 5) {
            return FIVE_MATCH;
        }
        if (matchCount == 6) {
            return SIX_MATCH;
        }
        return null;
    }
}
