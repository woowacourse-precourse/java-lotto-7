package lotto.domain;

public enum PrizeRank {
    FIRST(6, false, 2_000_000_000, "6개 일치"),
    SECOND(5, true, 30_000_000, "5개 일치, 보너스 볼 일치"),
    THIRD(5, false, 1_500_000, "5개 일치"),
    FOURTH(4, false, 50_000, "4개 일치"),
    FIFTH(3, false, 5_000, "3개 일치"),
    NONE(0, false, 0, "미당첨");

    private final int matchCount;
    private final boolean matchBonus;
    private final long prizeMoney;
    private final String description;

    PrizeRank(int matchCount, boolean matchBonus, long prizeMoney, String description) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
        this.prizeMoney = prizeMoney;
        this.description = description;
    }

    public static PrizeRank findByMatch(int matchCount, boolean matchBonus) {
        if (matchCount == 5 && matchBonus) {
            return SECOND;
        }
        for (PrizeRank rank : values()) {
            if (rank.matchCount == matchCount && !rank.matchBonus) {
                return rank;
            }
        }
        return NONE;
    }

    public long getPrizeMoney() {
        return prizeMoney;
    }

    public String getDescription() {
        return description;
    }
}
