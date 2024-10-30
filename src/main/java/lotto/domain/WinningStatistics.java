package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class WinningStatistics {
    private Map<Integer, Integer> statistics;

    private WinningStatistics(Map<Integer, Integer> statistics) {
        this.statistics = statistics;
    }

    public static WinningStatistics init() {
        Map<Integer, Integer> hashMap = new HashMap<>(Map.of(
                1, 0,
                2, 0,
                3, 0,
                4, 0,
                5, 0
        ));
        return new WinningStatistics(hashMap);
    }

    public void saveWinningResult(int rank) {
        statistics.put(rank, statistics.get(rank) + 1);
    }

    public Integer getRankCount(int rank) {
        return statistics.get(rank);
    }
}
