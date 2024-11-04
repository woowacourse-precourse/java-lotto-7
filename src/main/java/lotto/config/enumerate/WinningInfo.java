package lotto.config.enumerate;

import static lotto.config.constant.ExceptionMessageConstant.UNKNOWN_RANK;

import java.util.Arrays;

public enum WinningInfo {

    ZERO(0, 0, false),
    ONE(1, 0, false),
    TWO(2, 0, false),
    THREE(3, 5000, false),
    FOUR(4, 50_000, false),
    FIVE(5, 1_500_000, false),
    BONUS(5, 30_000_000, true),
    SIX(6, 2_000_000_000, false);

    private final int matchingNumbers;
    private final int prize;
    private final boolean isBonus;

    WinningInfo(int matchingNumbers, int prize, boolean isBonus) {
        this.matchingNumbers = matchingNumbers;
        this.prize = prize;
        this.isBonus = isBonus;
    }

    public int getMatchingNumbers() {
        return this.matchingNumbers;
    }


    public int getPrize() {
        return this.prize;
    }

    public boolean isBonus() {
        return isBonus;
    }

    public static WinningInfo getWinningInfo(int numberOfMatch, boolean isBonus) {
        return Arrays.stream(values())
                .filter(winningInfo -> winningInfo.matchingNumbers == numberOfMatch && winningInfo.isBonus == isBonus)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(UNKNOWN_RANK));
    }
}
