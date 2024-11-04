package lotto;

public class LottoProfit {
    private final int totalSpent;
    private final LottoResult lottoResult;

    public LottoProfit(int totalSpent, LottoResult lottoResult) {
        this.totalSpent = totalSpent;
        this.lottoResult = lottoResult;
    }

    public double calculateProfitRate() {
        int totalPrize = 0;

        for (LottoRank rank : LottoRank.values()) {
            totalPrize += lottoResult.getCount(rank) * rank.getPrizeAmount();
        }

        return (double) totalPrize / totalSpent * 100;
    }
}