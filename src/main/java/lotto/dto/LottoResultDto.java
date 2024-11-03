package lotto.dto;

import java.util.Map;
import java.util.SequencedMap;

public class LottoResultDto {
    private final Map<String,Integer> rankStatistics;
    private final double profitRate;

    private LottoResultDto(Map<String, Integer> rankStatistics, double profitRate) {
        this.rankStatistics = rankStatistics;
        this.profitRate = profitRate;
    }

    public static LottoResultDto of(Map<String, Integer> rankStatistics, double profitRate) {
        return new LottoResultDto(rankStatistics, profitRate);
    }

    public Map<String, Integer> getRankStatistics() {
        return Map.copyOf(rankStatistics);
    }

    public double getProfitRate() {
        return profitRate;
    }
}
