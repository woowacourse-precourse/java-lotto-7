package lotto.dto;

import java.util.Map;
import lotto.constant.LottoRank;

public record LottoResultResponse(
        Map<LottoRank, Integer> lottoResult,
        Double earningRate
) {
}
