package lotto.domain;

import java.util.Map;

public class RankResult {
    private Map<Rank,Integer> Rank_Count;
    private int Total_Price;

    public RankResult(Map<Rank,Integer> Rank_Count, int Total_Price) {
        this.Rank_Count = Rank_Count;
        this.Total_Price = Total_Price;
    }

    public RankResult(Map<Rank, Integer> rankResult) {
        this.Rank_Count = rankResult;
    }
}
