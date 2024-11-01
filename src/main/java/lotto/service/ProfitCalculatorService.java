package lotto.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;
import lotto.enums.Rank;

public class ProfitCalculatorService {

    public double calculateProfit(Map<Rank, Long> rankCount, int totalCost) {
        long totalProfit = rankCount.entrySet().stream()
                .mapToLong(entry -> entry.getKey().getAmount() * entry.getValue())
                .sum();

        if (totalCost == 0) {
            return 0.0; // 구입 금액이 0일 경우 수익률은 0으로 반환
        }

        BigDecimal profitRate = BigDecimal.valueOf((double) totalProfit / totalCost)
                .setScale(4, RoundingMode.HALF_UP);

        return profitRate.doubleValue();
    }
}
