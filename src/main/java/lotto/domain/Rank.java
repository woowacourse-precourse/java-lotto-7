package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2_000_000_000, false),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000, false),
    FOURTH(4, 50_000, false),
    FIFTH(3, 5_000, false),
    NONE(0, 0, false);

    private final int matchingCount;
    private final int prize;
    private final boolean hasBonusNumber;

    Rank(int matchingCount, int prize, boolean hasBonusNumber) {
        this.matchingCount = matchingCount;
        this.prize = prize;
        this.hasBonusNumber = hasBonusNumber;
    }

    public static Rank getWinnerPrize(int count, boolean hasBonus) {
        return Arrays.stream(values())
                .filter(rank -> rank.matchingCount == count)
                .filter(rank -> rank.hasBonusNumber == hasBonus)
                .findFirst()
                .orElse(NONE);
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public long getPrize() {
        return prize;
    }
}


