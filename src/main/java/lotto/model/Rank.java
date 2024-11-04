package lotto.model;

import java.util.Arrays;

public enum Rank {

    NONE(0, false, 0),
    FIFTH_PLACE(3, false, 5_000),
    FOURTH_PLACE(4, false, 50_000),
    THIRD_PLACE(5, false, 1_500_000),
    SECOND_PLACE(5, true, 30_000_000),
    FIRST_PLACE(6, false, 2_000_000_000);

    private final int matchingCount;
    private final boolean containsBonusNumber;
    private final int winningPrice;

    Rank(int matchingCount, boolean containsBonusNumber, int winningPrice) {
        this.matchingCount = matchingCount;
        this.containsBonusNumber = containsBonusNumber;
        this.winningPrice = winningPrice;
    }

    public int getWinningPrice() {
        return winningPrice;
    }

    public static Rank findRank(int matchingCount, boolean isBonusNumberMatches) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.matchingCount == matchingCount && rank.containsBonusNumber == isBonusNumberMatches)
                .findFirst()
                .orElse(Rank.NONE);
    }
}
