package lotto.service;

import java.util.Map;
import lotto.enums.Rank;

public class ProfitCalculatorService {

    public double calculateProfit(Map<Rank, Long> rankCount, int totalCost) {
        long totalProfit = rankCount.entrySet().stream()
                .mapToLong(entry -> entry.getKey().getAmount() * entry.getValue()).sum();

        if (totalCost == 0) {
            return 0.0;
        }
        double result = (double) totalProfit / (double) totalCost;
        return Math.round(result * 1000) / 10.0;
    }
}
