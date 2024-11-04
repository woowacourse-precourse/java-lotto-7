package lotto.enums;

public enum LottoRank {
    NO_MATCH(0, 0, false),
    THREE_MATCH(3, 5_000, false),
    FOUR_MATCH(4, 50_000, false),
    FIVE_MATCH(5, 1_500_000, false),
    FIVE_MATCH_WITH_BONUS(5, 30_000_000, true),
    SIX_MATCH(6, 2_000_000_000, false);

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
}