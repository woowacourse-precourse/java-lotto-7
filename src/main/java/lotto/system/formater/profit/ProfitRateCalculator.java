package lotto.system.formater.profit;

import java.util.Map;
import lotto.system.utils.PrizeType;

public class ProfitRateCalculator { // 수익률 계산기

    private final Map<PrizeType, Integer> statistics;
    private final int totalPurchaseAmount;

    public ProfitRateCalculator(Map<PrizeType, Integer> statistics, int totalPurchaseAmount) {
        this.statistics = statistics;
        this.totalPurchaseAmount = totalPurchaseAmount;
    }

    public double calculator() {
        int totalPrizeMoney = statistics.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrizeMoney() * entry.getValue())
                .sum();
        return ((double) totalPrizeMoney / (double) totalPurchaseAmount) * 100;
    }
}