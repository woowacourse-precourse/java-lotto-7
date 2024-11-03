package lotto;

public enum Rank {
    FIFTH(3, 5000),
    FOURTH(4, 50000),
    THIRD(5, 1500000),
    SECOND(5, 30000000),
    FIRST(6, 2000000000),
    NONE(-1, 0);

    private final int winningNumberMatchCount;
    private final int winningAmount;

    Rank(final int winningNumberMatchCount, final int winningAmount) {
        this.winningNumberMatchCount = winningNumberMatchCount;
        this.winningAmount = winningAmount;
    }

    public int getWinningNumberMatchCount() {
        return winningNumberMatchCount;
    }

    public int getWinningAmount() {
        return winningAmount;
    }
}
