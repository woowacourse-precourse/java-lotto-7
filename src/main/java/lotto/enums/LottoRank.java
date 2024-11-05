package lotto.enums;

public enum LottoRank {
    NO_MATCH(0, 0, false),
    THREE_MATCH(3, 5000, false),
    FOUR_MATCH(4, 50000, false),
    FIVE_MATCH(5, 1500000, false),
    FIVE_MATCH_WITH_BONUS(5, 30000000, true),
    SIX_MATCH(6, 2000000000, false);

    private final int matchCount;
    private final int reward;
    private final boolean matchesBonus;

    LottoRank(int matchCount, int reward, boolean matchesBonus) {
        this.matchCount = matchCount;
        this.reward = reward;
        this.matchesBonus = matchesBonus;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getReward() {
        return reward;
    }

    public boolean matchesBonus() {
        return matchesBonus;
    }

    public static LottoRank matchCountAndRank(int matchCount, boolean bonusMatch) {
        for (LottoRank rank : values()) {
            if (rank.getMatchCount() == matchCount && rank.matchesBonus() == bonusMatch) {
                return rank;
            }
        }
        return NO_MATCH;
    }
}