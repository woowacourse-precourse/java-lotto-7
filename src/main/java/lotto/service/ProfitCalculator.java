package lotto.service;

import lotto.model.*;
import java.util.Map;

public class ProfitCalculator {
    public double calculateProfit(Map<Rank, Integer> rankCounts, Money money) {
        validateInputs(rankCounts, money);

        long totalPrize = calculateTotalPrize(rankCounts);
        return calculateProfitRate(totalPrize, money.getAmount());
    }

    private long calculateTotalPrize(Map<Rank, Integer> rankCounts) {
        return rankCounts.entrySet().stream()
                .mapToLong(entry ->
                        (long) entry.getKey().getPrize() * entry.getValue())
                .sum();
    }

    private double calculateProfitRate(long totalPrize, int purchaseAmount) {
        double profitRate = (totalPrize * 100.0) / purchaseAmount;
        return Math.round(profitRate * 10) / 10.0;
    }

    private void validateInputs(Map<Rank, Integer> rankCounts, Money money) {
        if (money == null) {
            throw new IllegalStateException("구입 금액이 초기화되지 않았습니다.");
        }
        if (rankCounts == null || rankCounts.isEmpty()) {
            throw new IllegalStateException("당첨 결과가 계산되지 않았습니다.");
        }
    }
}
