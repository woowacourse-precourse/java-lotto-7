package lotto.Model;

public enum LottoResult {
    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    FIVE_WITH_BONUS(5, 30000000),
    SIX(6, 2000000000);

    private final int matchCount;
    private final int winningAmount;

    LottoResult(int matchCount, int winningAmount) {
        this.matchCount = matchCount;
        this.winningAmount = winningAmount;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getWinningAmount() {
        return winningAmount;
    }

    public String getFormattedWinningAmount() {
        return String.format("%,d", winningAmount);
    }
}


