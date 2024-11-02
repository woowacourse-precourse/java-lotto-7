package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    MISS(0, false, 0);

    private final int matchedCount;
    private final boolean bonus;
    private final long prize;

    Rank(int matchedCount, boolean bonus, long prize) {
        this.matchedCount = matchedCount;
        this.bonus = bonus;
        this.prize = prize;
    }

    // TODO: MISS를 반환하는게 맞는지
    public static Rank findByMatchedCount(int count) {
        return Arrays.stream(Rank.values())
            .filter(rank -> rank.matchedCount == count)
            .findAny().orElse(MISS);
    }
}
