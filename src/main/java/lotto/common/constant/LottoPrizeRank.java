package lotto.common.constant;

public enum LottoPrizeRank {
    FIRST(6, false, 2_000_000_000, "6개 일치"),
    SECOND(5, true, 30_000_000, "5개 일치, 보너스 볼 일치"),
    THIRD(5, false, 1_500_000, "5개 일치"),
    FOURTH(4, false, 50_000, "4개 일치"),
    FIFTH(3, false, 5_000, "3개 일치");

    private final int matchCount;
    private final boolean bonusMatch;
    private final long prizeMoney;
    private final String description;

    LottoPrizeRank(int matchCount, boolean bonusMatch, long prizeMoney, String description) {
        this.matchCount = matchCount;
        this.bonusMatch = bonusMatch;
        this.prizeMoney = prizeMoney;
        this.description = description;
    }

    public static LottoPrizeRank getLottoPrizeRank(int matchCount, boolean bonusMatch) {
        if (matchCount == 6) return FIRST;
        if (matchCount == 5 && bonusMatch) return SECOND;
        if (matchCount == 5) return THIRD;
        if (matchCount == 4) return FOURTH;
        return FIFTH;
    }

    public long getPrizeMoney() {
        return prizeMoney;
    }

    public String getDescription() {
        return description;
    }
}