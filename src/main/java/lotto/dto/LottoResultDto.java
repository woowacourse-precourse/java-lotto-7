package lotto.dto;

import java.util.Map;
import lotto.model.Rank;

public class LottoResultDto {
    private final Map<Rank, Integer> rankCounts;
    private final double profitRate;

    public LottoResultDto(Map<Rank, Integer> rankCounts, double profitRate) {
        this.rankCounts = rankCounts;
        this.profitRate = profitRate;
    }

    public Map<Rank, Integer> getRankCounts() {
        return rankCounts; // 랭크 카운트를 반환
    }

    public double getProfitRate() {
        return profitRate; // 수익률 반환
    }
}