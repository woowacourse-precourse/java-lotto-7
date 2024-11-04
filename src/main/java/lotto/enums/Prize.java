package lotto.enums;

import java.util.Arrays;

public enum Prize {
    NONE(0, 0, false),
    FIFTH(5_000, 3, false),
    FOURTH(50_000, 4, false),
    THIRD(1_500_000, 5, false),
    SECOND(30_000_000, 5, true),
    FIRST(2_000_000_000, 6, false);

    private final int prize;
    private final int matchCount;
    private final boolean isBonus;

    Prize(int prize, int matchCount, boolean isBonus) {
        this.prize = prize;
        this.matchCount = matchCount;
        this.isBonus = isBonus;
    }

    public static int getPrize(int matchCount, boolean isBonus) {
        return Arrays.stream(values())
                .filter(prize -> prize.matchCount == matchCount)
                .filter(prize -> prize.isBonus == isBonus)
                .findAny()
                .orElse(NONE)
                .getPrize();
    }

    public int getPrize() {
        return this.prize;
    }

}
