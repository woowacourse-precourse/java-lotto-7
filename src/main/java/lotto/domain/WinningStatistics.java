package lotto.domain;

import static lotto.domain.Rank.*;

import java.util.HashMap;
import java.util.Map;

public class WinningStatistics {
    private Map<Rank, Integer> statistics;

    private WinningStatistics(Map<Rank, Integer> statistics) {
        this.statistics = statistics;
    }

    public static WinningStatistics init() {
        Map<Rank, Integer> hashMap = new HashMap<>(Map.of(
                FIRST, 0,
                SECOND, 0,
                THIRD, 0,
                FOURTH, 0,
                FIFTH, 0,
                EMPTY, 0
        ));
        return new WinningStatistics(hashMap);
    }

    public void saveWinningResult(Rank rank) {
        statistics.put(rank, statistics.get(rank) + 1);
    }

    public Integer getRankCount(Rank rank) {
        return statistics.get(rank);
    }
}
