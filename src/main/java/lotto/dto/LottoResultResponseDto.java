package lotto.dto;


import java.math.BigDecimal;
import java.util.Map;
import lotto.domain.LottoRank;
import lotto.domain.LottoResult;

public class LottoResultResponseDto {

    private final Map<LottoRank, Integer> rankCounts;
    private final String yield;

    public LottoResultResponseDto(LottoResult lottoResult, BigDecimal yield) {
        this.rankCounts = lottoResult.getRankCounts();
        this.yield = yield.toPlainString();
    }

    public Map<LottoRank, Integer> getRankCounts() {
        return rankCounts;
    }

    public String getYield() {
        return yield;
    }
}