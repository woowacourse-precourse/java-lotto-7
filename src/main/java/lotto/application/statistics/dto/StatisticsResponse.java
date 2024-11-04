package lotto.application.statistics.dto;

import lotto.application.statistics.domain.Rank;
import lotto.application.statistics.domain.StatisticsResult;

public record StatisticsResponse(
        long firstCount,
        long secondCount,
        long thirdCount,
        long fourthCount,
        long fifthCount,
        double profitRate
) {
    public static StatisticsResponse from(StatisticsResult result, int purchaseAmount) {
        return new StatisticsResponse(
                result.getCount(Rank.FIRST),
                result.getCount(Rank.SECOND),
                result.getCount(Rank.THIRD),
                result.getCount(Rank.FOURTH),
                result.getCount(Rank.FIFTH),
                result.calculateProfitRate(purchaseAmount)
        );
    }
}
