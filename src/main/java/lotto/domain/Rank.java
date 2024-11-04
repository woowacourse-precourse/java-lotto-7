package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    NONE(0, false, 0);

    private final int matchCount;
    private final boolean bonusRequired;
    private final long prize;

    Rank(int matchCount, boolean bonusRequired, long prize) {
        this.matchCount = matchCount;
        this.bonusRequired = bonusRequired;
        this.prize = prize;
    }

    public long getPrize() {
        return prize;
    }

    public static Rank findRank(int matchCount, boolean hasBonus) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.matchCount == matchCount && (!rank.bonusRequired || hasBonus == rank.bonusRequired))
                .findFirst()
                .orElse(NONE);
    }
}
