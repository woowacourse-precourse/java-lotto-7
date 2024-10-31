package lotto;

public enum LottoRank {
    FIFTH_PRIZE(3, 5000), FOURTH_PRIZE(4, 50000), THIRD_PRIZE(5, 1500000), FIRST_PRIZE(6, 2000000000), SECOND_PRIZE(5, 30000000);

    private int matchCount;
    private int prize;
    private int winningCount;
    LottoRank(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public int getPrize() {
        return prize;
    }

    public void addWinningCount() {
        this.winningCount++;
    }

    public int getWinningCount() {
        return winningCount;
    }

    public int getMatchCount() {
        return matchCount;
    }
}
