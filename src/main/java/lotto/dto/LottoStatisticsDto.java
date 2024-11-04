package lotto.dto;

import java.util.Map;
import lotto.model.LottoStatistics;
import lotto.model.Rank;

public class LottoStatisticsDto {
    private final Map<Rank, Integer> rankCounts;
    private final double profitRate;

    public LottoStatisticsDto(Map<Rank, Integer> rankCounts, double profitRate) {
        this.rankCounts = rankCounts;
        this.profitRate = profitRate;
    }

    public Map<Rank, Integer> getRankCounts() {
        return rankCounts;
    }

    public double getProfitRate() {
        return profitRate;
    }

    public static LottoStatisticsDto from(LottoStatistics statistics) {
        return new LottoStatisticsDto(
                statistics.getRankCounts(),
                statistics.calculateProfitRate()
        );
    }
}
