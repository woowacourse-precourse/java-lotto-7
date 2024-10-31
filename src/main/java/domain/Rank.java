package domain;

import java.util.Arrays;

public enum Rank {
    FIRST_PLACE(6, 2000000000),
    SECOND_PLACE(5, 30000000),
    THIRD_PLACE(5, 1500000),
    FOURTH_PLACE(4, 50000),
    FIFTH_PLACE(3, 5000),
    NOTHING(0, 0);

    private int matchedCount;
    private long winningAmount;

    Rank(int matchedCount, long winningAmount) {
        this.matchedCount = matchedCount;
        this.winningAmount = winningAmount;
    }

    public static Rank findRank(int matchedCount, boolean isBonus) {
        Rank find = Arrays.stream(Rank.values())
                .filter(rank -> rank.matchedCount == matchedCount)
                .findFirst()
                .orElse(NOTHING);

        if (find == Rank.SECOND_PLACE && !isBonus) {
            return Rank.THIRD_PLACE;
        }

        return find;
    }

    public long getWinningAmount() {
        return winningAmount;
    }

}
