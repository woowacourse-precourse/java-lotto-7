package lotto.domain;

public enum PrizeLevel {
    MATCH_3("3개 일치 (5,000원)", 3, false, 5000),
    MATCH_4("4개 일치 (50,000원)", 4, false, 50000),
    MATCH_5("5개 일치 (1,500,000원)", 5, false, 1500000),
    MATCH_5_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원)", 5, true, 30000000),
    MATCH_6("6개 일치 (2,000,000,000원)", 6, false, 2000000000);

    private final String displayName;
    private final int matchCount;
    private final boolean bonusMatch;
    private final long prizeMoney;

    PrizeLevel(String displayName, int matchCount, boolean bonusMatch, long prizeMoney) {
        this.displayName = displayName;
        this.matchCount = matchCount;
        this.bonusMatch = bonusMatch;
        this.prizeMoney = prizeMoney;
    }

    public String getDisplayName() {
        return displayName;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isBonusMatch() {
        return bonusMatch;
    }

    public long getPrizeMoney() {
        return prizeMoney;
    }
}
