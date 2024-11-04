package lotto.model;

import lotto.constant.LottoConfig;

import java.util.Map;
import java.util.stream.Stream;

import static lotto.constant.SystemConfig.DEFAULT_VALUE;

public class LottosPrizeCount {
    private final Map<LottoConfig.Rank, Integer> prizeCounts;

    public LottosPrizeCount(Map<LottoConfig.Rank, Integer> prizeCounts) {
        this.prizeCounts = prizeCounts;
    }

    public Map<LottoConfig.Rank, Integer> getPrizeCounts() {
        return Map.copyOf(prizeCounts);
    }

    public Integer getCountForRank(LottoConfig.Rank rank) {
        return prizeCounts.getOrDefault(rank, DEFAULT_VALUE);
    }

    public long getTotalPrizeMoney() {
        return Stream.of(LottoConfig.Rank.values())
                .mapToLong(rank -> rank.calculatePrizeMoney(prizeCounts.getOrDefault(rank, DEFAULT_VALUE)))
                .sum();
    }
}
