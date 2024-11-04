package lotto.model;

public enum Rank {
    THREE_MATCHING(3, 5_000),
    FOUR_MATCHING(4, 50_000),
    FIVE_MATCHING(5, 1_500_000),
    FIVE_BONUS_MATCHING(5, 30_000_000),
    SIX_MATCHING(6, 2_000_000_000);
    private final int matchCount, prizeMoney;

    Rank(int matchCount, int prizeMoney) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
    }

    public int getMatchCount() {
        return this.matchCount;
    }

    public int getPrizeMoney() {
        return this.prizeMoney;
    }
}
