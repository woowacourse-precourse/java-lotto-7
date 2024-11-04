package lotto.domain;

public class RankCalculator {
    private final RankCalculationStrategy strategy;

    public RankCalculator(RankCalculationStrategy strategy) {
        this.strategy = strategy;
    }

    public Rank calculateRank(int matchedCount, boolean bonusMatched) {
        return strategy.calculateRank(matchedCount, bonusMatched);
    }
}
