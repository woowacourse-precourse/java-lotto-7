package lotto.domain;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

public class LottoResult {

    private Map<Ranking, Integer> lottoResult;

    public LottoResult() {
        this.lottoResult = new EnumMap<Ranking, Integer>(Ranking.class);
    }

    public void addResult(final Ranking ranking) {
        lottoResult.put(ranking, lottoResult.getOrDefault(ranking, 0) + 1);
    }

    public Map<Ranking, Integer> getLottoResult() {
        return Collections.unmodifiableMap(lottoResult);
    }
}
