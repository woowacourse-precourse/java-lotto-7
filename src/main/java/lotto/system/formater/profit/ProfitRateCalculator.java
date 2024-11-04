package lotto.system.formater.profit;

import java.util.Map;
import lotto.system.utils.PrizeType;

public class ProfitRateCalculator { // 수익률 계산기

    public static ProfitRate calculateProfitRate(Map<PrizeType, Integer> statistics, int totalPurchaseAmount) {
        int totalPrizeMoney = statistics.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrizeMoney() * entry.getValue())
                .sum();

        double profitRateValue = ((double) totalPrizeMoney / (double) totalPurchaseAmount) * 100;
        return new ProfitRate(profitRateValue);
    }

}