package lotto.model;

import java.util.Map;
import java.util.Map.Entry;

public class LottoWinningResult {

    private final Map<LottoRank, Integer> lottoWinningResult;

    public LottoWinningResult(Map<LottoRank, Integer> lottoRankResult) {
        this.lottoWinningResult = lottoRankResult;
    }

    public double calculateRateOfReturn(PurchaseAmount purchaseAmount) {
        long proceeds = calculateTotalWinningPrice();
        int investmentAmount = purchaseAmount.getPurchaseAmount();
        return calculatePercentage(proceeds, investmentAmount);
    }

    private long calculateTotalWinningPrice() {
        return this.lottoWinningResult.entrySet().stream()
                .mapToLong(this::sumWinningAmount)
                .sum();
    }

    private double calculatePercentage(long proceeds, int investmentAmount) {
        return (double) proceeds / investmentAmount * 100.0;
    }

    private long sumWinningAmount(Entry<LottoRank, Integer> rank) {
        return rank.getKey().getWinningAmount() * rank.getValue();
    }

    public Map<LottoRank, Integer> getLottoWinningResult() {
        return lottoWinningResult;
    }
}
