package lotto;

public class LottoProfit {
    private final int totalSpent;
    private int totalPrize;

    public LottoProfit(int totalSpent) {
        this.totalSpent = totalSpent;
        this.totalPrize = 0;
    }

    public void addPrize(int matchCount, LottoRank rank) {
        totalPrize += matchCount * rank.getWinningMoney();
    }

    public double calculateYield() {
        if (totalSpent == 0) {
            return 0.0;
        }
        double yield = ((double) totalPrize / totalSpent) * 100;
        return Math.round(yield * 10.0) / 10.0;
    }

    public int getTotalPrize() {
        return totalPrize;
    }
}
