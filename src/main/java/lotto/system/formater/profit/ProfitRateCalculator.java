package lotto.system.formater.profit;

import java.util.Map;
import lotto.system.utils.PrizeType;

public class ProfitRateCalculator {
    public static double calculate(Map<PrizeType, Integer> statistics, int totalPurchaseAmount) {
        int totalPrizeMoney = statistics.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrizeMoney() * entry.getValue())
                .sum();
        return ((double) totalPrizeMoney / (double) totalPurchaseAmount) * 100;
    }
}
