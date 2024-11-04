package lotto.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class RankResult {
    private final Map<Rank, Long> rankResult;

    public RankResult(Map<Rank, Long> rankResult) {
        this.rankResult = new HashMap<>(rankResult);
    }

    public Money calculateWinningAmount() {
        return Arrays.stream(Rank.values())
                .map(rank -> rank.getPrize().multiply(rankResult.getOrDefault(rank, 0L)))
                .reduce(new Money(0L), Money::add);
    }

    public Map<Rank, Long> getRankResult() {
        return Collections.unmodifiableMap(rankResult);
    }
}
