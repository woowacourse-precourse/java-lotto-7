package lotto;

import java.util.List;
import lotto.common.LottoResult;

public class Results {

    private final List<LottoResult> lottoResults;

    public Results(final List<LottoResult> lottoResults) {
        this.lottoResults = lottoResults;
    }

    public int getSum() {
        return lottoResults.stream()
                .mapToInt(lottoResult -> lottoResult.getWinningAmount())
                .sum();
    }
}
