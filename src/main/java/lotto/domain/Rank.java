package lotto.domain;

import java.util.Arrays;

public enum Rank {
    NOTHING(0, 0),
    FIFTH_PLACE(3, 5000),
    FOURTH_PLACE(4, 50000),
    THIRD_PLACE(5, 1500000),
    SECOND_PLACE(5, 30000000),
    FIRST_PLACE(6, 2000000000);

    private final int matchedCount;
    private final long winningAmount;

    Rank(int matchedCount, long winningAmount) {
        this.matchedCount = matchedCount;
        this.winningAmount = winningAmount;
    }

    public static Rank findRank(int matchedCount, boolean isBonus) {
        Rank find = Arrays.stream(Rank.values())
                .filter(rank -> rank.matchedCount == matchedCount)
                .findFirst()
                .orElse(NOTHING);

        if (find == Rank.THIRD_PLACE && isBonus) {
            return Rank.SECOND_PLACE;
        }

        return find;
    }

    public int getMatchedCount() {
        return matchedCount;
    }

    public long getWinningAmount() {
        return winningAmount;
    }

}
