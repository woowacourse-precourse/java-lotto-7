package lotto.constant;

import static lotto.constant.ExceptionMessageConstant.UNKNOWN_RANK;

import java.util.Arrays;

public enum WinningInfo {

    ZERO(0, 0),
    ONE(1, 0),
    TWO(2, 0),
    THREE(3, 5000),
    FOUR(4, 50_000),
    FIVE(5, 1_500_000),
    BONUS(5, 3_000_000),
    SIX(6, 2_000_000_000);

    private final int matchingNumbers;
    private final int prize;

    WinningInfo(int matchingNumbers, int prize) {
        this.matchingNumbers = matchingNumbers;
        this.prize = prize;
    }

    public static WinningInfo getWinningInfo(int numberOfMatch) {
        return Arrays.stream(values())
                .filter(statistic -> statistic.matchingNumbers == numberOfMatch)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(UNKNOWN_RANK));
    }
}
