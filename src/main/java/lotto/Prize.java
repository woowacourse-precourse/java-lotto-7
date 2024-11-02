package lotto;

public enum Prize {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000);

    private final int matchCount;
    private final boolean bonusMatch;
    private final int amount;

    Prize(int matchCount, boolean bonusMatch, int amount) {
        this.matchCount = matchCount;
        this.bonusMatch = bonusMatch;
        this.amount = amount;
    }

    public static int getPrizeAmount(int matchCount, boolean bonusMatch) {
        for (Prize prize : values()) {
            if (prize.matchCount == matchCount && prize.bonusMatch == bonusMatch) {
                return prize.amount;
            }
        }
        return 0;
    }
}
