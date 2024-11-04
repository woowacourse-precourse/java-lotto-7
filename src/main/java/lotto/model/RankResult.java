package lotto.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class RankResult {
    private static final long MINIMUM_AMOUNT = 0L;
    private final Map<Rank, Long> rankResult;

    public RankResult(Map<Rank, Long> rankResult) {
        this.rankResult = new HashMap<>(rankResult);
    }

    public Money calculateWinningAmount() {
        return Arrays.stream(Rank.values())
                .map(rank -> rank.getPrize().multiply(rankResult.getOrDefault(rank, MINIMUM_AMOUNT)))
                .reduce(new Money(MINIMUM_AMOUNT), Money::add);
    }

    public double calculateRateOfResult(Money purchaseAmount) {
        return calculateWinningAmount().divide(purchaseAmount);
    }


    public Map<Rank, Long> getRankResult() {
        return Collections.unmodifiableMap(rankResult);
    }
}
