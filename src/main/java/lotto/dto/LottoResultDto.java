package lotto.dto;

import java.util.SequencedMap;

public class LottoResultDto {
    private final SequencedMap<String,Integer> rankStatistics;
    private final double profitRate;

    public LottoResultDto(SequencedMap<String, Integer> rankStatistics, double profitRate) {
        this.rankStatistics = rankStatistics;
        this.profitRate = profitRate;
    }

    public static LottoResultDto of(SequencedMap<String, Integer> rankStatistics, double profitRate) {
        return new LottoResultDto(rankStatistics, profitRate);
    }

    public SequencedMap<String, Integer> rankStatistics() {
        return rankStatistics;
    }

    public double getProfitRate() {
        return profitRate;
    }
}
