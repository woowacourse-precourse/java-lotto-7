package lotto.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Statistics {

    private final Map<Rank, Integer> winningResult;
    private final long totalPrize;
    private final Money purchaseAmount;

    public Statistics(final List<Rank> ranks) {
        this.winningResult = createWinningResult(ranks);
        this.totalPrize = calculateTotalPrize(winningResult);
        this.purchaseAmount = Money.fromLottoCount(ranks.size());
    }

    private Map<Rank, Integer> createWinningResult(final List<Rank> ranks) {
        final Map<Rank, Integer> winningResult = new EnumMap<>(Rank.class);
        ranks.forEach(rank -> winningResult.put(rank, winningResult.getOrDefault(rank, 0) + 1));
        return winningResult;
    }

    private long calculateTotalPrize(final Map<Rank, Integer> winningMap) {
        return winningMap.entrySet().stream()
                .mapToLong(entry -> (long) entry.getKey().getPrize() * entry.getValue())
                .sum();
    }

    public Map<Rank, Integer> getWinningResult() {
        return Map.copyOf(winningResult);
    }

    public BigDecimal getYield() {
        if (this.totalPrize == 0) {
            return BigDecimal.ZERO;
        }
        final BigDecimal totalPrize = BigDecimal.valueOf(this.totalPrize);
        final BigDecimal purchaseAmount = BigDecimal.valueOf(this.purchaseAmount.getAmount());

        return totalPrize
                .multiply(BigDecimal.valueOf(100))
                .divide(purchaseAmount, 1, RoundingMode.HALF_UP);
    }
}
