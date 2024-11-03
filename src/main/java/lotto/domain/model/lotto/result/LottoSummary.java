package lotto.domain.model.lotto.result;

import lotto.domain.model.user.LottoRank;

import java.util.Map;

public class LottoSummary {

    Map<LottoRank, Long> resultMap;

    private LottoSummary(Map<LottoRank, Long> resultMap) {
        this.resultMap = resultMap;
    }

    public static LottoSummary create(Map<LottoRank, Long> resultMap) {
        return new LottoSummary(resultMap);
    }

    public Long getWinningCount(LottoRank rank, long defaultValue) {
        return this.resultMap.getOrDefault(rank, defaultValue);
    }

    public double getProfitRate(int totalPurchaseAmount) {
        long totalPrize = resultMap.entrySet().stream()
                .mapToLong(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();

        return calculateProfitRate(totalPurchaseAmount, totalPrize);
    }

    private double calculateProfitRate(int totalPurchaseAmount, long totalPrize) {
        double profitRate = (double) totalPrize / totalPurchaseAmount * 100;
        return Math.round(profitRate * 10) / 10.0;
    }

    public int getSize() {
        return resultMap.size();
    }
}
