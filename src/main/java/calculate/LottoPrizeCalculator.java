package calculate;

import java.util.Map;
import lottoRank.LottoRankStructure;

public class LottoPrizeCalculator {
    public long calculateTotalPrize(Map<LottoRankStructure, Integer> results) {
        return results.entrySet().stream()
                .mapToLong(entry -> (long) entry.getKey().getPrize() * entry.getValue())
                .sum();
    }
}
