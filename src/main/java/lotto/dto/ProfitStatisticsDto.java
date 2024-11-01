package lotto.dto;

import java.util.Map;
import lotto.configuration.Prize;

public class ProfitStatisticsDto {
    private final Map<Prize, Integer> prizeCountMap;
    private final double profitRate;

    public ProfitStatisticsDto(Map<Prize, Integer> prizeCountMap, double profitRate) {
        if (prizeCountMap == null) {
            throw new IllegalArgumentException("prizeCountMap cannot be null");
        }
        this.prizeCountMap = prizeCountMap;
        this.profitRate = profitRate;
    }

    public Map<Prize, Integer> getPrizeCountMap() {
        return prizeCountMap;
    }

    public double getProfitRate() {
        return profitRate;
    }
}
