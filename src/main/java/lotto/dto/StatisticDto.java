package lotto.dto;

import static lotto.config.LottoRank.FIFTH_RANK;
import static lotto.config.LottoRank.FIRST_RANK;
import static lotto.config.LottoRank.FOURTH_RANK;
import static lotto.config.LottoRank.SECOND_RANK;
import static lotto.config.LottoRank.THIRD_RANK;

import java.util.Map;
import lotto.config.LottoRank;
import lotto.model.Statistic;

public class StatisticDto {
    private static final int INITIAL_COUNT = 0;

    private final Map<LottoRank, Integer> statisticResult;

    private StatisticDto(Map<LottoRank, Integer> statisticResult) {
        this.statisticResult = statisticResult;
    }

    public static StatisticDto from(final Statistic statistic) {
        Map<LottoRank, Integer> statisticResult = statistic.getStatisticResult();

        return new StatisticDto(Map.copyOf(statisticResult));
    }

    private Map<LottoRank, Integer> getStatisticResult() {
        return Map.copyOf(statisticResult);
    }

    public Integer getFifthRankCount() {
        return getStatisticResult().getOrDefault(FIFTH_RANK, INITIAL_COUNT);
    }

    public Integer getFourthRankCount() {
        return getStatisticResult().getOrDefault(FOURTH_RANK, INITIAL_COUNT);
    }

    public Integer getThirdRankCount() {
        return getStatisticResult().getOrDefault(THIRD_RANK, INITIAL_COUNT);
    }

    public Integer getSecondRankCount() {
        return getStatisticResult().getOrDefault(SECOND_RANK, INITIAL_COUNT);
    }

    public Integer getFirstRankCount() {
        return getStatisticResult().getOrDefault(FIRST_RANK, INITIAL_COUNT);
    }
}
