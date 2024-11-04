package lotto.model;

import java.util.Map;

public class LottoRevenueCalculator {
    private final Map<LottoRank, Integer> lottoResult;
    private final int moneySpent;

    private LottoRevenueCalculator(Map<LottoRank, Integer> lottoResult, int moneySpent) {
        this.lottoResult = lottoResult;
        this.moneySpent = moneySpent;
    }

    public static LottoRevenueCalculator of(Map<LottoRank, Integer> lottoResult, int moneySpent) {
        return new LottoRevenueCalculator(lottoResult, moneySpent);
    }

    public double calculateRevenue() {
        int moneyEarned = lottoResult.entrySet()
                .stream()
                .mapToInt(entry -> entry.getKey().getPrizeAmount() * entry.getValue())
                .sum();
        return (double) moneyEarned / moneySpent * 100;
    }
}
