package lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private final Map<LottoRank, Integer> lottoResults = new HashMap<>();

    public LottoResult(List<LottoRank> lottoRanks) {
        for (LottoRank rank : lottoRanks) {
            lottoResults.merge(rank, 1, Integer::sum);
        }
    }

    public Integer getLottoResults(LottoRank lottoRank) {
        return lottoResults.getOrDefault(lottoRank, 0);
    }

    public Integer calculateTotalIncome() {
        return lottoResults.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
    }
}
