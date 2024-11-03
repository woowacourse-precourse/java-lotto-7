package lotto.info;

import java.util.Arrays;

public enum WinningInfo {
    FIRST(1, 6, 2000000000),
    SECOND(2, 5, 30000000),
    THIRD(3, 5, 1500000),
    FOURTH(4, 4, 50000),
    FIFTH(5, 3, 5000);

    private final int rank;
    private final int matchCount;
    private final int winningPrice;

    WinningInfo(int rank, int matchCount, int winningPrice) {
        this.rank = rank;
        this.matchCount = matchCount;
        this.winningPrice = winningPrice;
    }

    public int getRank() {
        return rank;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getWinningPrice() {
        return winningPrice;
    }

    public static WinningInfo getRankByMatchCountAndBonus(int matchCount, boolean hasBonus) {
        if (matchCount == SECOND.matchCount) {
            if (hasBonus) {
                return SECOND;
            }
            return THIRD;
        }

        return Arrays.stream(values())
                .filter(info -> info.matchCount == matchCount && (info != SECOND || !hasBonus))
                .findFirst()
                .orElse(null);
    }
}
