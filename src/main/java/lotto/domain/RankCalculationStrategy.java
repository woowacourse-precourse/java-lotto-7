package lotto.domain;

public interface RankCalculationStrategy {
    Rank calculateRank(int matchedCount, boolean bonusMatched);
}