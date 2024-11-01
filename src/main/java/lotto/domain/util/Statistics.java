package lotto.domain.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import lotto.domain.Lotto;
import lotto.global.common.Rank;

public final class Statistics {

    private final Map<Rank, Integer> rankMap;

    private Statistics(List<Rank> ranks) {
        this.rankMap = countRanks(ranks);
    }

    public static Statistics of(List<Rank> ticketResults) {
        return new Statistics(ticketResults);
    }

    public double calculateProfitRate() {
        final double seed = Lotto.TICKET_PRICE * rankMap.size();
        int profit = 0;

        for (Entry<Rank, Integer> entry : rankMap.entrySet()){
            profit += entry.getKey().price * entry.getValue();
        }

        return profit / seed * 100;
    }

    private Map<Rank, Integer> countRanks(List<Rank> ranks) {
        Map<Rank, Integer> statistics = new HashMap<>();

        for (Rank rank : ranks) {
            statistics.put(rank, statistics.getOrDefault(rank, 0) + 1);
        }

        return statistics;
    }
}
