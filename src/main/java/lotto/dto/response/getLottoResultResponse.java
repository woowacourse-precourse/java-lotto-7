package lotto.dto.response;

import lotto.domain.LottoRank;

import java.util.Map;

public record getLottoResultResponse(
        Map<LottoRank, Integer> result,
        Long prizeMoney
) {
    public static getLottoResultResponse of(Map<LottoRank, Integer> result, Long prize) {
        return new getLottoResultResponse(result, prize);
    }
}
