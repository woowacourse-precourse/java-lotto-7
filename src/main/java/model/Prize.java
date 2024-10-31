package model;

public enum Prize {
    FIRST(6, false, 2000000000),
    SECOND(5, true, 30000000),
    THIRD(5, false, 1500000),
    FOURTH(4, false, 50000),
    FIFTH(3, false, 5000),
    MISS(0, false, 0);

    private final int matchCount;
    private final boolean matchBonus;
    private final int prizeMoney;

    Prize(int matchCount, boolean matchBonus, int prizeMoney) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
        this.prizeMoney = prizeMoney;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isMatchBonus() {
        return matchBonus;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public static Prize prizeOf(int matchCount, boolean matchBonus) {
        for (Prize prize : Prize.values()) {
            if (prize.matchCount == matchCount && prize.matchBonus) {
                return prize;
            }
        }
        return MISS;
    }
}
