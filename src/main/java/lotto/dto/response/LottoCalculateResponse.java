package lotto.dto.response;

import java.util.Map;
import lotto.domain.type.LottoRank;

public record LottoCalculateResponse(
        Map<LottoRank, Integer> prizeCounts,
        double earningRate
) {
    public static LottoCalculateResponse of(Map<LottoRank, Integer> prizeCounts, double earningRate) {
        return new LottoCalculateResponse(prizeCounts, earningRate);
    }
}