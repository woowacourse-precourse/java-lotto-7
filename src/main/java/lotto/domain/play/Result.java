package lotto.domain.play;

import lotto.domain.rule.PrizeRank;

import java.util.Map;

public class Result {
    private final Map<PrizeRank, Integer> prizeRankCounts;

    public Result(Map<PrizeRank, Integer> prizeRankCounts) {
        this.prizeRankCounts = prizeRankCounts;
    }

    public int findCount(PrizeRank prizeRank) {
        return prizeRankCounts.get(prizeRank);
    }

    public int calculateTotalProfit() {
        return prizeRankCounts.entrySet()
                .stream()
                .map(this::calculateProfit)
                .mapToInt(Integer::intValue)
                .sum();
    }

    private int calculateProfit(Map.Entry<PrizeRank, Integer> entry) {
        return entry.getValue() * entry.getKey().getPrize();
    }
}
