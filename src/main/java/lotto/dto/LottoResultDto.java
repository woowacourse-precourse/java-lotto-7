package lotto.dto;

import java.util.Map;
import lotto.domain.LottoRank;

public class LottoResultDto {
    private final Map<LottoRank, Integer> rankCounts;
    private final double returnRate;

    public LottoResultDto(Map<LottoRank, Integer> rankCounts, double returnRate) {
        this.rankCounts = rankCounts;
        this.returnRate = returnRate;
    }

    public Map<LottoRank, Integer> getRankCounts() {
        return rankCounts;
    }

    public double getReturnRate() {
        return returnRate;
    }
}
