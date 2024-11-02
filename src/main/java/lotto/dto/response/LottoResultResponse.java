package lotto.dto.response;

import lotto.domain.Ranking;

import java.util.Map;

public record LottoResultResponse(
        Map<Ranking, Integer> lottoResult
) {
    public static LottoResultResponse from(Map<Ranking, Integer> lottoResult) {
        return new LottoResultResponse(lottoResult);
    }
}