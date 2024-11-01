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
}
