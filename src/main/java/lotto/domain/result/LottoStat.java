package lotto.domain.result;

import lotto.domain.model.LottoRank;

import java.util.HashMap;
import java.util.Map;

public class LottoStat {
    private Map<LottoRank, Integer> stats;

    public LottoStat(Map<LottoRank, Integer> stats) {
        this.stats = new HashMap<>(stats);
    }

    public Map<LottoRank, Integer> getStats() {
        return new HashMap<>(stats);
    }

    public void updateStat(LottoRank lottoRank, int count) {
        stats.put(lottoRank, stats.getOrDefault(lottoRank, 0) + count);
    }
}
