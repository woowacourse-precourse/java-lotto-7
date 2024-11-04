package lotto.dto.response;

import lotto.domain.type.LottoRank;

import java.util.Map;

public record LottoCalculateResponse(
        Map<LottoRank, Integer> prizeCounts,
        double earningRate
) {
    public static LottoCalculateResponse of(Map<LottoRank, Integer> prizeCounts, double earningRate) {
        return new LottoCalculateResponse(prizeCounts, earningRate);
    }
}