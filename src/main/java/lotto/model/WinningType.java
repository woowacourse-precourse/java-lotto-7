package lotto.model;

import java.util.Arrays;

public enum WinningType {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    NONE(0, false, 0);

    private final int matchCount;
    private final boolean bonusMatchRequired;
    private final int prize;

    WinningType(int matchCount, boolean bonusMatchRequired, int prize) {
        this.matchCount = matchCount;
        this.bonusMatchRequired = bonusMatchRequired;
        this.prize = prize;
    }

    public int getPrize() {
        return prize;
    }

    public static WinningType valueOf(int matchCount, boolean bonusMatch) {
        return Arrays.stream(values())
                .filter(type -> type.matchCount == matchCount)
                .filter(type -> !type.bonusMatchRequired || bonusMatch)
                .findFirst()
                .orElse(NONE);
    }
}
