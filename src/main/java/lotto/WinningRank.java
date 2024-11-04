package lotto;

import java.util.Arrays;

public enum WinningRank {
    NOTHING(0, false, 0),
    FIFTH(3, false, 5000),
    FOURTH(4, false, 50000),
    THIRD(5, false, 1500000),
    SECOND(5, true, 30000000),
    FIRST(6, false, 2000000000);

    WinningRank(int matchCount, boolean matchBonus, int prizeAmount) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
        this.prizeAmount = prizeAmount;
    }

    private final int matchCount;
    private final boolean matchBonus;
    private final int prizeAmount;

    public static WinningRank getWinningRank(int matchCount, boolean matchBonus) {
        return Arrays.stream(WinningRank.values())
            .filter(rank -> rank.matchCount == matchCount && rank.matchBonus == matchBonus)
            .findFirst()
            .orElse(NOTHING);
    }
}
