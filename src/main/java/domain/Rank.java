package domain;

import java.util.Arrays;

public enum Rank {

    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NO_RANK(0, 0);

    private final int correctCount;
    private final int prizeMoney;

    Rank(int correctCount, int prizeMoney) {
        this.correctCount = correctCount;
        this.prizeMoney = prizeMoney;
    }

    public static Rank of(long input) {
        return Arrays.stream(values())
                .filter(correctCount -> correctCount.isEqual(input))
                .findFirst()
                .orElse(NO_RANK);
    }

    private boolean isEqual(long input) {
        return input == this.correctCount;
    }

    public int getPrizeMoney() {
        return this.prizeMoney;
    }
}
