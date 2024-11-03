package lotto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.EnumMap;

public class WinningResult {
    private final EnumMap<Rank, Integer> counts;
    private final Money money;

    public WinningResult(EnumMap<Rank, Integer> counts, Money money) {
        this.counts = counts;
        this.money = money;
    }

    public BigDecimal calculateTotalPrize() {
        return counts.entrySet()
                .stream()
                .map(entry -> entry.getKey().getPrize().multiply(BigDecimal.valueOf(entry.getValue())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal calculatePrizeRate() {
        BigDecimal totalPrize = calculateTotalPrize();
        BigDecimal value = totalPrize.divide(BigDecimal.valueOf(money.getAmount()), 2, RoundingMode.HALF_UP);
        return value.multiply(BigDecimal.TEN);
    }
}
