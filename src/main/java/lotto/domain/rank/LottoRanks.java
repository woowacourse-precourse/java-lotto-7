package lotto.domain.rank;

import java.util.EnumMap;
import java.util.Map;
import java.util.Map.Entry;
import lotto.domain.money.Money;

public class LottoRanks {

    private static final int DEFAULT_RATE_OF_RETURN = 0;
    private static final double RATE = 100.0;

    private final Map<LottoRank, Integer> ranks = new EnumMap<>(LottoRank.class);

    public void add(LottoRank rank) {
        ranks.put(rank, ranks.getOrDefault(rank, 0) + 1);
    }

    public Map<LottoRank, Integer> getRanks() {
        return Map.copyOf(ranks);
    }

    public double calculateTotalReturnRate(Money money) {
        if (money.isEmpty()) {
            return DEFAULT_RATE_OF_RETURN;
        }
        long totalReturn = getTotalReturn(ranks);
        return (double) totalReturn / money.amount() * RATE;
    }

    private long getTotalReturn(Map<LottoRank, Integer> ranks) {
        return ranks.entrySet().stream()
                .mapToLong(this::calculateRewardAmount)
                .sum();
    }

    private long calculateRewardAmount(Entry<LottoRank, Integer> rankEntry) {
        return (long) rankEntry.getKey().getRewardAmount() * rankEntry.getValue();
    }

}
