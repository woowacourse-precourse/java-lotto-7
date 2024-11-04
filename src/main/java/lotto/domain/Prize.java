package lotto.domain;

public enum Prize {
    THREE_MATCH(3, false, 0, 5_000),
    FOUR_MATCH(4, false, 1, 50_000),
    FIVE_MATCH(5, false, 2, 1_500_000),
    FIVE_MATCH_WITH_BONUS(5, true, 3, 30_000_000),
    SIX_MATCH(6, false, 4, 2_000_000_000);

    private final int matchCount;
    private final boolean bonusMatch;
    private final int index;
    private final int prizeAmount;

    Prize(int matchCount, boolean bonusMatch, int index, int prizeAmount) {
        this.matchCount = matchCount;
        this.bonusMatch = bonusMatch;
        this.index = index;
        this.prizeAmount = prizeAmount;
    }

    public int getIndex() {
        return index;
    }

    public static Prize getPrize(int matchCount, boolean bonusMatch) {
        for (Prize prize : values()) {
            if (prize.matchCount == matchCount && prize.bonusMatch == bonusMatch) {
                return prize;
            }
        }
        return null;
    }
}
