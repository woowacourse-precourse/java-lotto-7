package lotto.dto;

import java.util.List;

public record ProfitStatisticsDto(List<PrizeCountEntry> prizeCountEntries, double profitRate) {
    public ProfitStatisticsDto {
        if (prizeCountEntries == null) {
            throw new IllegalArgumentException("prizeCountMap cannot be null");
        }
    }

    public static class Builder {
        List<PrizeCountEntry> prizeCountEntries;

        double profitRate;

        public Builder prizeCount(List<PrizeCountEntry> prizeCountEntries) {
            this.prizeCountEntries = prizeCountEntries;
            return this;
        }

        public Builder profitRate(double profitRate) {
            this.profitRate = profitRate;
            return this;
        }

        public ProfitStatisticsDto build() {
            return new ProfitStatisticsDto(prizeCountEntries, profitRate);
        }
    }
}
