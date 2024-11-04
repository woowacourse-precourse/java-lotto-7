package lotto.configuration;

import java.util.Arrays;

public enum Prize {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, null, 1_500_000),
    FOURTH(4, null, 50_000),
    FIFTH(3, null, 5_000),
    NONE(0, null, 0);

    final private int matchCount;
    final private Boolean matchBonus;
    final private long prizeMoney;

    Prize(int matchCount, Boolean matchBonus, int prizeMoney) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
        this.prizeMoney = prizeMoney;
    }

    public static Prize findPrize(int matchCount, boolean matchBonus) {
        return Arrays.stream(Prize.values())
                .filter(prize -> isMatchingPrize(prize, matchBonus, matchCount))
                .findFirst()
                .orElse(NONE);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public long getPrizeMoney() {
        return prizeMoney;
    }

    private static boolean isMatchingPrize(Prize prize, boolean matchBonus, int matchCount) {
        return (prize.matchBonus != null && prize.matchBonus == matchBonus && prize.matchCount == matchCount) ||
               (prize.matchBonus == null && (prize.matchCount == matchCount || (prize.matchCount == matchCount + 1
                                                                                && matchBonus)));
    }


}
