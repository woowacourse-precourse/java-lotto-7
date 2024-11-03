package lotto;

import java.math.BigDecimal;
import java.util.Map;

public class WinningResult {
    private final Map<Rank, Integer> counts;
    private final Money money;

    public WinningResult(Map<Rank, Integer> counts, Money money) {
        this.counts = counts;
        this.money = money;
    }

    public BigDecimal calculateTotalPrize() {
        return counts.entrySet()
                .stream()
                .map(entry -> entry.getKey().getPrize().multiply(BigDecimal.valueOf(entry.getValue())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal calculateTotalPrizeRate() {
        BigDecimal totalPrize = calculateTotalPrize();
        return money.calculateTotalPrizeRate(totalPrize);
    }

    public Map<Rank, Integer> getCounts() {
        return counts;
    }
}
