package lotto.model.lotto.prize;

public enum LottoPrizeInfo {
    FIRST_PRIZE(6, false, 2_000_000_000L),
    SECOND_PRIZE(5, true, 30_000_000L),
    THIRD_PRIZE(5, false, 1_500_000L),
    FOURTH_PRIZE(4, false, 50_000L),
    FIFTH_PRIZE(3, false, 5_000L),
    NONE(0, false, 0L);

    private final int matchCount;
    private final boolean requiresBonus;
    private final long prizeAmount;

    LottoPrizeInfo(int matchCount, boolean requiresBonus, long prizeAmount) {
        this.matchCount = matchCount;
        this.requiresBonus = requiresBonus;
        this.prizeAmount = prizeAmount;
    }

    public long getPrizeAmount() {
        return prizeAmount;
    }

    public static LottoPrizeInfo getPrizeByMatch(int matchCount, boolean bonusMatch) {
        for (LottoPrizeInfo prize : values()) {
            if (prize.matchCount == matchCount && prize.requiresBonus == bonusMatch) {
                return prize;
            }
        }
        return NONE;
    }
}
