package lotto.domain.strategy;

import lotto.domain.model.Rank;

public class DefaultRankCalculationStrategy implements RankCalculationStrategy {

    @Override
    public Rank calculateRank(int matchedCount, boolean bonusMatched) {
        if (matchedCount == 6) {
            return Rank.FIRST;
        } else if (matchedCount == 5 && bonusMatched) {
            return Rank.SECOND;
        } else if (matchedCount == 5) {
            return Rank.THIRD;
        } else if (matchedCount == 4) {
            return Rank.FOURTH;
        } else if (matchedCount == 3) {
            return Rank.FIFTH;
        } else {
            return Rank.NONE;
        }
    }
}
