package lotto.model;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.config.LottoRank;

public class Statistic {
    private static final Integer FIVE_MATCHES = 5;
    private static final Integer INCREMENT = 1;

    private final Map<LottoRank, Integer> statisticResult;

    private Statistic(Map<LottoRank, Integer> statisticResult) {
        this.statisticResult = statisticResult;
    }

    public static Statistic createStatistic(final List<Integer> matchedNumberCount,
                                            final List<Boolean> containsBonusNumber) {
        return new Statistic(compileStatistic(matchedNumberCount, containsBonusNumber));
    }

    private static Map<LottoRank, Integer> compileStatistic(List<Integer> matchedCounts,
                                                            List<Boolean> bonusIncludedFlags) {
        Map<LottoRank, Integer> result = new EnumMap<>(LottoRank.class);

        for (int i = 0; i < matchedCounts.size(); i++) {
            LottoRank rank = determineRank(matchedCounts.get(i), bonusIncludedFlags.get(i));
            result.merge(rank, INCREMENT, Integer::sum);
        }

        return result;
    }

    private static LottoRank determineRank(final int matches, final boolean bonusIncluded) {
        if (matches == FIVE_MATCHES && bonusIncluded) {
            return LottoRank.SECOND_RANK;
        }
        return LottoRank.getRankByMatches(matches);
    }

    public Map<LottoRank, Integer> getStatisticResult() {
        return Map.copyOf(statisticResult);
    }
}
