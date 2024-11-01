package lotto.entity;

public enum Prize {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, null, 1_500_000),
    FOURTH(4, null, 50_000),
    FIFTH(3, null, 5_000),
    NONE(0, null, 0);

    final private int matchCount;
    final private boolean matchBonus;
    final private int prizeMoney;

    Prize(int matchCount, Boolean matchBonus, int prizeMoney) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
        this.prizeMoney = prizeMoney;
    }

    public static Prize findPrize(int matchCount, boolean matchBonus) {
        for (Prize prize : Prize.values()) {
            if (prize.matchCount == matchCount && prize.matchBonus == matchBonus) {
                return prize;
            }
        }
        return NONE;
    }
}
