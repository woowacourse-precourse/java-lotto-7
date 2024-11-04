package lotto.dto;

import java.util.List;
import lotto.exception.DtoExceptionMessage;
import lotto.exception.ExceptionUtils;

public record ProfitStatisticsDto(List<PrizeCountEntry> prizeCountEntries, double profitRate) {

    public ProfitStatisticsDto {
        if (prizeCountEntries == null) {
            throw ExceptionUtils.IllegalArgument(DtoExceptionMessage.NULL_EXCEPTION);
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
