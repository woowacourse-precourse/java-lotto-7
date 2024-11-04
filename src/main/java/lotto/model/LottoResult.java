package lotto.model;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    private final Map<LottoRank, Integer> resultStats = new HashMap<>();

    public Map<LottoRank, Integer> getResultStats() {
        return resultStats;
    }

    public LottoResult() {
        for (LottoRank rank : LottoRank.values()) {
            resultStats.put(rank, 0);
        }
    }

    public void update(LottoRank rank) {
        int count = resultStats.get(rank);
        resultStats.put(rank, count + 1);
    }
}
