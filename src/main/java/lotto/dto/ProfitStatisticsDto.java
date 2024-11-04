package lotto.dto;

import java.util.Map;
import lotto.configuration.Prize;

public record ProfitStatisticsDto(Map<Prize, Integer> prizeCountMap, double profitRate) {
    public ProfitStatisticsDto {
        if (prizeCountMap == null) {
            throw new IllegalArgumentException("prizeCountMap cannot be null");
        }
    }

    public static class Builder {
        Map<Prize, Integer> prizeCountMap;
        double profitRate;

        public Builder prizeCountMap(Map<Prize, Integer> prizeCountMap) {
            this.prizeCountMap = prizeCountMap;
            return this;
        }

        public Builder profitRate(double profitRate) {
            this.profitRate = profitRate;
            return this;
        }

        public ProfitStatisticsDto build() {
            return new ProfitStatisticsDto(prizeCountMap, profitRate);
        }
    }
}
