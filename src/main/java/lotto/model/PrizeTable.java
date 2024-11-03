package lotto.model;

public enum PrizeTable {
    THREE_MATCHES(3, 5_000),
    FOUR_MATCHES(4, 50_000),
    FIVE_MATCHES(5, 1_500_000),
    FIVE_BONUS_MATCHES(5, 30_000_000),
    SIX_MATCHES(6, 2_000_000_000);

    private final int prizeMoney;
    private final int matchNumbers;
    private int winningCount = 0;

    PrizeTable(int matchNumbers, int prizeMoney) {
        this.matchNumbers = matchNumbers;
        this.prizeMoney = prizeMoney;
    }

    public void addWinningCount() {
        winningCount++;
    }

    public int getWinningCount() {
        return winningCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public int getMatchNumbers() {
        return matchNumbers;
    }

    public int getTotalPrizeMoney() {
        return winningCount * prizeMoney;
    }
}
