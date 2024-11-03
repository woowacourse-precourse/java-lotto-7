package lotto.util;

import java.util.Arrays;

public enum WinningRank {
    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    BONUS(5, 3000000),
    SIX(6, 2000000000);

    private final int matchingNumbers;
    private final int prize;

    WinningRank(int matchingNumbers, int prize) {
        this.matchingNumbers = matchingNumbers;
        this.prize = prize;
    }

    public static WinningRank getRank(int numberOfMatch, boolean hasBonus) {
        return Arrays.stream(values())
                .filter(statistic -> statistic.matchingNumbers == numberOfMatch)
                .filter(statistic -> {
                    // 5개가 일치하는 경우 보너스 번호 여부를 확인
                    if (numberOfMatch == 5 && hasBonus) {
                        return statistic == BONUS;
                    }
                    if (numberOfMatch == 5) {
                        return statistic == FIVE;
                    }
                    return true;
                })
                .findFirst()
                .orElse(null);
    }
}

