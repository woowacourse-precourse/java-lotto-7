package lotto.model;

import java.util.Map;
import lotto.enums.Prize;

public class CalculatePrize {
    private final Map<Prize, Integer> prizeIntegerMap;
    long totalPrize = 0L;
    long money;

    public CalculatePrize(Map<Prize, Integer> prizeIntegerMap, Long money) {
        this.prizeIntegerMap = prizeIntegerMap;
        this.money = money;
        calculateAllPrize();
    }

    private Long calculateAllPrize() {
        for (Map.Entry<Prize, Integer> entry : prizeIntegerMap.entrySet()) {
            totalPrize += (long) entry.getKey().getPrize() * entry.getValue();
        }
        return totalPrize;
    }

    public double calculatePrizeRate() {
        return (double) (totalPrize) / money * 100;
    }
}
