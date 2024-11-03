package lotto.domain;

import java.util.HashMap;

public class LottoWinningStatistics {
    private final HashMap<LottoRank, Integer> statistics = new HashMap<>();

    public void updateWinningNumber(LottoRank key) {
        int value = statistics.getOrDefault(key, 0) + 1;
        statistics.put(key, value);
    }

    public int searchWinningNumber(LottoRank key) {
        return statistics.getOrDefault(key, 0);
    }
}
