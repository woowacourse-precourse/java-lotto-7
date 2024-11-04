package lotto.lottoMachine.calculateManager;

import java.util.Map;
import lotto.lottoMachine.utils.LottoResultStructure;

public class LottoPrizeManager {
    private final Map<LottoResultStructure, Integer> results;

    public LottoPrizeManager(Map<LottoResultStructure, Integer> results) {
        this.results = results;
    }
    public long getTotalPrize() {
        return results.entrySet().stream()
                .mapToLong(entry -> (long) entry.getKey().getPrize() * entry.getValue())
                .sum();
    }
}
