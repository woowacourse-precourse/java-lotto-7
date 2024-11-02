package lotto.model;

import java.util.Map;

public class LottoWinningResult {

    private final Map<LottoRank, Integer> lottoWinningResult;

    private LottoWinningResult(Map<LottoRank, Integer> lottoRankResult) {
        this.lottoWinningResult = lottoRankResult;
    }

    public static LottoWinningResult from(Map<LottoRank, Integer> lottoRankResult) {
        return new LottoWinningResult(lottoRankResult);
    }

    public double calculateRateOfReturn(PurchaseAmount purchaseAmount) {
        long proceeds = calculateTotalWinningPrice();
        int investmentAmount = purchaseAmount.getPurchaseAmount();
        return calculatePercentage(proceeds, investmentAmount);
    }

    private long calculateTotalWinningPrice() {
        return this.lottoWinningResult.entrySet().stream()
                .mapToLong(rank -> rank.getKey().getWinningAmount() * rank.getValue()).sum();
    }

    private double calculatePercentage(long proceeds, int investmentAmount) {
        return (double) proceeds / investmentAmount * 100.0;
    }

    public Map<LottoRank, Integer> getLottoWinningResult() {
        return lottoWinningResult;
    }
}
