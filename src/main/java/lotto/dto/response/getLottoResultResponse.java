package lotto.dto.response;

import lotto.domain.LottoRank;

import java.util.Map;

public record getLottoResultResponse(
        Map<LottoRank, Integer> result,
        double returnRate
) {
    public static getLottoResultResponse of(Map<LottoRank, Integer> result, double returnRate) {
        return new getLottoResultResponse(result, returnRate);
    }
}
