package lotto.constant;

public enum LottoGrade {

    THREE_MATCHED(3, 5000),
    FOUR_MATCHED(4, 50000),
    FIVE_MATCHED(5, 1_500_000),
    BONUS_MATCHED(5, 30_000_000),
    ALL_MATCHED(6, 2_000_000_000);

    private final int matched;
    private final long winningAmount;

    LottoGrade(int matched, int winningAmount) {
        this.matched = matched;
        this.winningAmount = winningAmount;
    }

    public int getMatched() {
        return matched;
    }

    public long getWinningAmount() {
        return winningAmount;
    }
}
