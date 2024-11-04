package lotto.model;

import java.util.Arrays;

public enum WinningType {
    NONE(0, false, 0),
    FIFTH(3, false, 5_000),
    FOURTH(4, false, 50_000),
    THIRD(5, false, 1_500_000),
    SECOND(5, true, 30_000_000),
    FIRST(6, false, 2_000_000_000);

    private final int matchCount;
    private final boolean matchBonus;
    private final long prize;

    WinningType(int matchCount, boolean matchBonus, long prize) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
        this.prize = prize;
    }

    public static WinningType of(int matchCount, boolean matchBonus) {
        return Arrays.stream(WinningType.values())
                .filter(winningType -> hasSameMatchCount(matchCount, winningType) 
                        && hasSameMatchBonus(matchBonus, winningType))
                .findFirst()
                .orElse(NONE);
    }

    public long getPrize() {
        return prize;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean getMatchBonus() {
        return matchBonus;
    }

    public boolean isNotNone() {
        return this != NONE;
    }

    private static boolean hasSameMatchBonus(boolean matchBonus, WinningType winningType) {
        return winningType.matchBonus == matchBonus;
    }

    private static boolean hasSameMatchCount(int matchCount, WinningType winningType) {
        return winningType.matchCount == matchCount;
    }
}
