package lotto;

public enum Rank {

    FIRST(6, 2000000000),
    SECOND(5, true, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    NONE(0, 0);

    private final int matchCount;
    private final boolean requireBonus;
    private final int prizeMoney;

    Rank(int matchCount, int prizeMoney) {
        this(matchCount, false, prizeMoney);
    }

    Rank(int matchCount, boolean requireBonus, int prizeMoney) {
        this.matchCount = matchCount;
        this.requireBonus = requireBonus;
        this.prizeMoney = prizeMoney;
    }

    public static Rank valueOf(int matchCount, boolean matchBonus) {
        if (matchCount == 5) {
            if (matchBonus) {
                return SECOND;
            }
            return THIRD;
        }
        return getRankWithoutBonus(matchCount);
    }

    public static Rank getRankWithoutBonus(int matchCount) {
        for (Rank rank : Rank.values()) {
            if (rank.matchCount == matchCount && !rank.requireBonus) {
                return rank;
            }
        }
        return NONE;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
}
