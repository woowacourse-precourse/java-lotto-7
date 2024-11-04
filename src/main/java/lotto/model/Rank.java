package lotto.model;

public enum Rank {
    NONE(0, false, 0, "꽝"),
    FIFTH(3, false, 5000, "3개 일치 (5,000원)"),
    FOURTH(4, false, 50000, "4개 일치 (50,000원)"),
    THIRD(5, false, 1500000, "5개 일치 (1,500,000원)"),
    SECOND(5, true, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    FIRST(6, false, 2000000000, "6개 일치 (2,000,000,000원)");

    private final int matchCount;
    private final boolean bonusMatch;
    private final int prizeMoney;
    private final String description;

    Rank(int matchCount, boolean bonusMatch, int prizeMoney, String description) {
        this.matchCount = matchCount;
        this.bonusMatch = bonusMatch;
        this.prizeMoney = prizeMoney;
        this.description = description;
    }

    public static Rank valueOf(int matchCount, boolean bonusMatch) {
        for (Rank rank : Rank.values()) {
            if (rank.matchCount == matchCount && rank.bonusMatch == bonusMatch) {
                return rank;
            }
        }
        return NONE;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public String getDescription() {
        return description;
    }
}
