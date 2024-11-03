package lotto;

import java.math.BigDecimal;
import java.math.RoundingMode;
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

    // TODO: Money 한테 책임 주기
    public BigDecimal calculatePrizeRate() {
        BigDecimal totalPrize = calculateTotalPrize();
        return totalPrize.multiply(BigDecimal.valueOf(100)).divide(money.getAmount(), 1, RoundingMode.HALF_UP);
    }

    public Map<Rank, Integer> getCounts() {
        return counts;
    }
}
