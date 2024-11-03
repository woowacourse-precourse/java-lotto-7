package lotto.model;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

public final class PrizeStatistics {
    private final Map<PrizeRank, Integer> statistics;

    private PrizeStatistics(Map<PrizeRank, Integer> statistics) {
        this.statistics = new EnumMap<>(statistics);
    }

    public static PrizeStatistics createPrizeStatistics() {
        Map<PrizeRank, Integer> statistics = new EnumMap<>(PrizeRank.class);

        for (PrizeRank rank : PrizeRank.values()) {
            statistics.put(rank, 0);
        }

        return new PrizeStatistics(statistics);
    }

    public void addStatistic(PrizeRank rank) {
        statistics.put(rank, statistics.get(rank) + 1);
    }

    public Map<PrizeRank, Integer> getStatistics() {
        return Collections.unmodifiableMap(statistics);
    }
}
