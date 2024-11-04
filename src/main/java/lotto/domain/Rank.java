package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(2_000_000_000, 6, false),
    SECOND(30_000_000, 5, true),
    THIRD(1_500_000, 5, false),
    FOURTH(50_000, 4, false),
    FIFTH(5_000, 3, false),
    DRAW(0, 0, false);

    private final int prize;
    private final int requiredHitCount;
    private final boolean requiresBonusNumber;

    Rank(int prize, int requiredHitCount, boolean requiresBonusNumber) {
        this.prize = prize;
        this.requiredHitCount = requiredHitCount;
        this.requiresBonusNumber = requiresBonusNumber;
    }

    public static Rank of(int matchCount, boolean isBonusNumberMatched) {
        return Arrays.stream(Rank.values())
            .filter(rank -> rank.requiredHitCount == matchCount)
            .filter(rank -> matchCount != SECOND.requiredHitCount
                || rank.requiresBonusNumber == isBonusNumberMatched)
            .findFirst()
            .orElse(DRAW);
    }

    public int getPrize() {
        return prize;
    }

    public int getRequiredHitCount() {
        return requiredHitCount;
    }
}
