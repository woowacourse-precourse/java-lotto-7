package domain;

import java.util.Arrays;

public enum WinningLotto {

    FIRST(1, 6, 2_000_000_000),
    SECOND(2, 5, 30_000_000),
    THIRD(3, 5, 1_500_000),
    FOURTH(4, 4, 50_000),
    FIFTH(5, 3, 5_000),
    NO_RANK(6, 0, 0);

    private final int rank;
    private final int correctCount;
    private final int prizeMoney;

    WinningLotto(int rank, int correctCount, int prizeMoney) {
        this.rank = rank;
        this.correctCount = correctCount;
        this.prizeMoney = prizeMoney;
    }

    public static WinningLotto from(long input) {
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
