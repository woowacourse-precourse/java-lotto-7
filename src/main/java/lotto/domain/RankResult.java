package lotto.domain;

import java.util.Map;

public class RankResult {
    private Map<Rank,Integer> Rank_Count;

    public RankResult(Map<Rank, Integer> rankResult) {
        this.Rank_Count = rankResult;
    }
    public Map<Rank, Integer> getRank_Count() {
        return Rank_Count;
    }
}
