package lotto.dto;

import java.util.Map;
import lotto.domain.Rank;

public class LottoResultDto {
    private final Map<Rank, Integer> rankCounts;
    private final double profitRate;

    public LottoResultDto(Map<Rank, Integer> rankCounts, double profitRate) {
        this.rankCounts = rankCounts;
        this.profitRate = profitRate;
    }

    public Map<Rank, Integer> getRankCounts() {
        return rankCounts;
    }

    public double getProfitRate() {
        return profitRate;
    }

}