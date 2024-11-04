package lotto.domain.strategy;

import lotto.domain.model.Rank;

public interface RankCalculationStrategy {
    Rank calculateRank(int matchedCount, boolean bonusMatched);
}