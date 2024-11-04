package lotto.model;

import lotto.constant.LottoConfig;

import java.util.Map;

public class LottosPrizeCount {
    private final Map<LottoConfig.Rank, Integer> prizeCounts;

    public LottosPrizeCount(Map<LottoConfig.Rank, Integer> prizeCounts) {
        this.prizeCounts = prizeCounts;
    }

    public Map<LottoConfig.Rank, Integer> getPrizeCounts() {
        return Map.copyOf(prizeCounts);
    }
}
