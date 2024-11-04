package lotto.domain.strategy;

import java.util.Map;
import lotto.domain.model.Rank;

public class DefaultRankCalculationStrategy implements RankCalculationStrategy {

    private static final Map<Integer, Rank> RANK_BY_MATCH_COUNT = Map.of(
            6, Rank.FIRST,
            5, Rank.THIRD,
            4, Rank.FOURTH,
            3, Rank.FIFTH
    );

    @Override
    public Rank calculateRank(int matchedCount, boolean bonusMatched) {
        if (matchedCount == 5 && bonusMatched) {
            return Rank.SECOND;
        }
        return RANK_BY_MATCH_COUNT.getOrDefault(matchedCount, Rank.NONE);
    }
}