package lotto.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningStatistics {
    private final Map<Ranking, Integer> counter;
    private final BigDecimal roi;

    public WinningStatistics(List<Ranking> rankings, int investmentCost) {
        this.counter = initializeCounter(rankings);
        this.roi = calculateROI(investmentCost);
    }

    public BigDecimal getRoi() {
        return roi;
    }

    private Map<Ranking, Integer> initializeCounter(List<Ranking> rankings) {
        Map<Ranking, Integer> counter = new HashMap<>();
        for (Ranking ranking : rankings) {
            counter.compute(ranking, (key, count) -> count == null ? 1 : count + 1);
        }
        return counter;
    }

    private BigDecimal calculateROI(final int investmentCost) {
        BigDecimal totalPrize = calculateTotalPrize();
        return totalPrize.multiply(BigDecimal.valueOf(100))
                .divide(BigDecimal.valueOf(investmentCost), 1, RoundingMode.HALF_UP);
    }

    private BigDecimal calculateTotalPrize() {
        return counter.entrySet().stream()
                .map(entry -> BigDecimal.valueOf(entry.getKey().getPrizeMoney())
                        .multiply(BigDecimal.valueOf(entry.getValue())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public Map<Ranking, Integer> getCounter() {
        return Collections.unmodifiableMap(counter);
    }
}
