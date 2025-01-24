package lotto.domain;

import java.util.Arrays;

public enum WinningPrize {
    FIRST(6, 0, 2_000_000_000),
    SECOND(5, 1, 30_000_000),
    THIRD(5, 0, 1_500_000),
    FORTH(4, 0, 50_000),
    FIFTH(3, 0, 5_000),
    ZERO(0, 0, 0);

    public final int winningCount;
    public final int bonusCount;
    public final int prizeMoney;


    WinningPrize(int winningCount, int bonusCount, int prizeMoney) {
        this.winningCount = winningCount;
        this.bonusCount = bonusCount;
        this.prizeMoney = prizeMoney;
    }

    public static WinningPrize getPrize(int playerWinningCount, int playerBonusCount) {
        return Arrays.stream(WinningPrize.values())
                .filter(e -> e.winningCount == playerWinningCount && e.bonusCount == playerBonusCount)
                .findFirst()
                .orElse(ZERO);
    }

    public int getMoney() {
        return prizeMoney;
    }

}
