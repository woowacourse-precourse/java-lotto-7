package lotto.calculateManager;

import java.util.Map;
import lotto.lottoMachine.lottoRank.LottoRankStructure;

public class LottoPrizeManager {
    private final Map<LottoRankStructure, Integer> results;

    public LottoPrizeManager(Map<LottoRankStructure, Integer> results) {
        this.results = results;
    }
    public long getTotalPrize() {
        return results.entrySet().stream()
                .mapToLong(entry -> (long) entry.getKey().getPrize() * entry.getValue())
                .sum();
    }
}
