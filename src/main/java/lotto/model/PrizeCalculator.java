package lotto.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;
import lotto.enums.Prize;

public class PrizeCalculator {
    private static final String OVER_FLOW_ERROR_MESSAGE = "오버플로우가 발생했습니다.";
    private final Map<Prize, Long> prizeIntegerMap;
    long totalPrize = 0L;
    long money;

    public PrizeCalculator(Map<Prize, Long> prizeIntegerMap, Long money) {
        this.prizeIntegerMap = prizeIntegerMap;
        this.money = money;
        calculateAllPrize();
    }

    private Long calculateAllPrize() {
        for (Map.Entry<Prize, Long> entry : prizeIntegerMap.entrySet()) {
            totalPrize += entry.getKey().getPrize() * entry.getValue();
        }
        validateOverflow(totalPrize);
        return totalPrize;
    }

    private void validateOverflow(long totalPrize) {
        if (totalPrize < 0L) {
            throw new IllegalStateException(OVER_FLOW_ERROR_MESSAGE);
        }
    }

    public double calculatePrizeRate() {
        return round(100.0 * (totalPrize) / money);
    }

    private double round(double rate) {
        BigDecimal decimal = BigDecimal.valueOf(rate);
        decimal = decimal.setScale(1, RoundingMode.HALF_UP);
        return decimal.doubleValue();
    }

    public long getTotalPrize() {
        return totalPrize;
    }
}
