package lotto.domain;

import java.util.Arrays;

public enum Rank {
    THREE(3, 5000L, false),
    FOUR(4, 50000L, false),
    FIVE(5, 1500000L, false),
    FIVE_AND_BONUS(5, 30000000L, true),
    SIX(6, 2000000000L, false),
    NONE(0, 0L, false);

    private final int matchCount;
    private final long prize;
    private final boolean matchBonus;

    Rank(int matchCount, long prize, boolean matchBonus) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.matchBonus = matchBonus;
    }

    public static Rank matchLotto(int matchCount, boolean matchBonus) {
        if (matchCount == 5 && matchBonus) {
            return Rank.FIVE_AND_BONUS;
        }

        if (matchCount == 5) {
            return Rank.FIVE;
        }

        return Arrays.stream(values()).filter(rank -> rank.matchCount == matchCount).findAny().orElse(Rank.NONE);
    }

    public long calculateTotalEarnings(int count) {
        return count * prize;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public long getPrize() {
        return prize;
    }

    public boolean isMatchBonus() {
        return matchBonus;
    }
}
