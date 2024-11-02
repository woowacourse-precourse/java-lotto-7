package lotto.model;

public enum WinningRank {
    FIRST(1, 6, 2000000000),
    SECOND(2, 5, 30000000),
    THIRD(3, 5, 1500000),
    FOURTH(4, 4, 50000),
    FIFTH(5, 3, 5000),
    FAIL(-1, -1, 0)
    ;

    private final int rank;
    private final int matchingAmount;
    private final int price;

    WinningRank(int rank, int matchingAmount, int price) {
        this.rank = rank;
        this.matchingAmount = matchingAmount;
        this.price = price;
    }

    public static WinningRank fromMatchingAmount(int matchingAmount, boolean matchesBonusNumber) {
        for (WinningRank winningRank : WinningRank.values()) {
            if (matchingAmount == winningRank.matchingAmount) {
                return fromMatchesBonusNumber(winningRank, matchingAmount, matchesBonusNumber);
            }
        }
        return FAIL;
    }

    private static WinningRank fromMatchesBonusNumber(WinningRank winningRank, int matchingAmount, boolean matchesBonusNumber) {
        if (matchingAmount == 5) {
            if (matchesBonusNumber) {
                return WinningRank.SECOND;
            }
            return WinningRank.THIRD;
        }
        return winningRank;
    }
}
