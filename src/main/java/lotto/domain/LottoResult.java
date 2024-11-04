package lotto.domain;

import java.util.EnumMap;
import java.util.List;

public class LottoResult {

    private final EnumMap<Rank, Integer> results;

    private LottoResult(List<Rank> ranks) {
        this.results = new EnumMap<>(Rank.class);
        ranks.forEach(rank -> results.put(rank, results.getOrDefault(rank, 0) + 1));
    }

    public static LottoResult createResult(List<Rank> ranks) {
        return new LottoResult(ranks);
    }

    public Long getTotalPrize() {
        return results.entrySet().stream()
                .mapToLong(entry -> (long) entry.getKey().getPrize() * entry.getValue())
                .sum();
    }

    public Long calculateRevenueRate(int payment) {
        return getTotalPrize() / payment * 100;
    }

}
