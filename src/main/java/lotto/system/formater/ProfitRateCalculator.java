package lotto.system.formater;

import java.util.Map;
import lotto.system.utils.PrizeType;

public class ProfitRateCalculator {
    public static int calculate(Map<PrizeType, Integer> statistics) {
        int totalPrizeMoney = statistics.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrizeMoney() * entry.getValue())
                .sum();
        return (totalPrizeMoney / statistics.getOrDefault(PrizeType.FIRST_PRIZE, 0)) * 100;
    }
}
