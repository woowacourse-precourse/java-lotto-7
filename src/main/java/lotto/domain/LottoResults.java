package lotto.domain;

import java.util.Map;

public class LottoResults {
    private final Map<LottoRank, Integer> prizeCount;

    public LottoResults() {
        prizeCount = LottoRank.initializePrizeCount();
    }
}
