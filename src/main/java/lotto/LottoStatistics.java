package lotto;

import java.util.HashMap;
import java.util.Map;

public class LottoStatistics {
    private final Map<LottoResult, Integer> statistics = new HashMap<>();

    public LottoStatistics() {
        for (LottoResult result : LottoResult.values()) {
            statistics.put(result, 0);
        }
    }

    public void recordWin(LottoResult result) {
        if (result != null) {
            statistics.put(result, statistics.get(result) + 1);
        }
    }

    public Map<LottoResult, Integer> getStatistics() {
        return statistics;
    }
}
