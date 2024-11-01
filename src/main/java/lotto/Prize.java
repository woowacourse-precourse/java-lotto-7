package lotto;

//당첨 등수와 상금
public enum Prize {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    NONE(0, false, 0);

    private final int matchCount;
    private final boolean matchBonus;
    private final int prizeMoney;

    Prize(int matchCount, boolean matchBonus, int prizeMoney) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
        this.prizeMoney = prizeMoney;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public static Prize valueOf(int matchCount, boolean matchBonus) {
        for (Prize prize : values()) {
            if (prize.matchCount == matchCount && prize.matchBonus == matchBonus) {
                return prize;
            }
        }
        return NONE;
    }
}
