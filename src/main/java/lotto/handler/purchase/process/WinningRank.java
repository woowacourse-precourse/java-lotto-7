package lotto.handler.purchase.process;

public enum WinningRank {
    FIRST(2000000000),
    SECOND(30000000),
    THIRD(1500000),
    FOURTH(50000),
    FIFTH(5000),
    LOSE(0);

    private final int winningAmount;

    WinningRank(int winningAmount) {
        this.winningAmount = winningAmount;
    }

    public int getWinningAmount() {
        return winningAmount;
    }
}
