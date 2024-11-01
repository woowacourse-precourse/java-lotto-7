package lotto;

public enum WinningRank {
    FAIL(-1, 0),
    FIFTH(3, 5000),
    FOURTH(4, 50000),
    THIRD(5, 1500000),
    SECOND(5, 30000000),
    FIRST(6, 2000000000);

    private final int matchingAmount;
    private final int price;

    WinningRank(int matchingAmount, int price) {
        this.matchingAmount = matchingAmount;
        this.price = price;
    }

    public static WinningRank findWinningStatusByMatchingAmount(int matchingAmount, boolean matchesBonusNumber) {
        for (WinningRank winningRank : WinningRank.values()) {
            if (matchingAmount == winningRank.matchingAmount) {
                return findWinningStatus(winningRank, matchingAmount, matchesBonusNumber);
            }
        }
        return FAIL;
    }

    public static WinningRank findWinningStatus(WinningRank winningRank, int matchingAmount, boolean matchesBonusNumber) {
        if (matchingAmount == 5) {
            if (matchesBonusNumber) {
                return SECOND;
            }
            return THIRD;
        }
        return winningRank;
    }
}
