package lotto;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Statistic {

    private final Map<Rank, Integer> statistics;

    public Statistic(List<Rank> ranks) {
        this.statistics = createStatistics(ranks);

    }

    private Map<Rank, Integer> createStatistics(List<Rank> ranks) {
        Map<Rank, Integer> newStatistics = new TreeMap<>();
        for (Rank rank : Rank.values()) {
            int frequency = countRankFrequency(ranks, rank);
            newStatistics.put(rank, frequency);
        }
        return newStatistics;
    }

    private int countRankFrequency(List<Rank> ranks, Rank objectiveRank) {
        return Collections.frequency(ranks, objectiveRank);
    }

    public int getFrequencyOf(Rank rank) {
        return statistics.get(rank);
    }
}
