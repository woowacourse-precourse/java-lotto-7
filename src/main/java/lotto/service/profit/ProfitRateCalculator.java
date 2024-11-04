package lotto.service.profit;

import java.util.Map;
import lotto.domain.ProfitRate;
import lotto.utils.PrizeType;

public class ProfitRateCalculator { // 수익률 계산기

    public static ProfitRate calculateProfitRate(Map<PrizeType, Integer> statistics, int totalPurchaseAmount) {
        int totalPrizeMoney = getSumPrizeMoney(statistics);
        double profitRateValue = getProfitRateValue(totalPurchaseAmount, totalPrizeMoney);

        return new ProfitRate(profitRateValue);
    }

    private static int getSumPrizeMoney(Map<PrizeType, Integer> statistics) {
        return statistics.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrizeMoney() * entry.getValue())
                .sum();
    }

    private static double getProfitRateValue(double totalPurchaseAmount, double totalPrizeMoney) {
        return (totalPrizeMoney / totalPurchaseAmount) * 100;
    }

}