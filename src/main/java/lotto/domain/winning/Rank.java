package lotto.domain.winning;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    NONE(0, 0);

    private final int matchCount;
    private final int winningMoney;

    Rank(int matchCount, int winningMoney) {
        this.matchCount = matchCount;
        this.winningMoney = winningMoney;
    }

    public static Rank findRank(int matchCount, boolean hasBonusNumber) {
        return Arrays.stream(values())
                .filter(rank -> rank.matchCount == matchCount)
                .findFirst()
                .map(rank -> {
                    if (rank == SECOND && !hasBonusNumber) {
                        return THIRD;
                    }
                    return rank;
                })
                .orElse(NONE);
    }

    public String formatWinningStatistics(int count) {
        if (this == SECOND) {
            return String.format("%d개 일치, 보너스 볼 일치 (%s원) - %d개",
                    matchCount, String.format("%,d", winningMoney), count);
        } else {
            return String.format("%d개 일치 (%s원) - %d개",
                    matchCount, String.format("%,d", winningMoney), count);
        }
    }

    public int getWinningMoney() {
        return winningMoney;
    }
}
