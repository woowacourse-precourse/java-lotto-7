package lotto.domain;

import java.util.Map;

public class LottoResult {

    private final Map<Rank, Integer> result;
    private final int lottoCount;

    public LottoResult(Map<Rank, Integer> result, int lottoCount) {
        this.result = result;
        this.lottoCount = lottoCount;
    }

    public int getMatchesCount(Rank rank) {
        return result.getOrDefault(rank, 0);
    }
}
