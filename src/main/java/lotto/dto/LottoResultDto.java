package lotto.dto;

import java.util.Map;
import lotto.domain.LottoResult;

public record LottoResultDto(
        Map<Integer, Integer> prizeMatchResults,
        double rateOfReturn
) {
    public static LottoResultDto of(final LottoResult lottoResult) {
        return new LottoResultDto(lottoResult.getPrizeMatchResults(), lottoResult.calculateRateOfReturn());
    }
}
