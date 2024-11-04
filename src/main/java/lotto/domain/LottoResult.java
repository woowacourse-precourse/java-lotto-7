package lotto.domain;

import java.util.Map;

public class LottoResult {
    private final Map<LottoPolicy, Integer> results;

    public LottoResult(Map<LottoPolicy, Integer> results) {
        for (LottoPolicy rank : LottoPolicy.values()) {
            results.put(rank, 0);
        }
        this.results = results;
    }

    public Map<LottoPolicy, Integer> getResults() {
        return results;
    }
}
