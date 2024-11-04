package lotto.model;

import java.util.HashMap;
import java.util.Map;

public class Result {

    private final Map<Rank, Integer> matchedRank;
    private long totalPrize;

    public Result() {
        matchedRank = new HashMap<Rank, Integer>();
        for (Rank rank : Rank.values()) {
            matchedRank.put(rank, 0);
        }
    }

    public int getNumberOfThatRank(Rank rank){
        return matchedRank.get(rank);
    }

    public long getTotalPrize() {
        return totalPrize;
    }

    public void updateMatchedRank(Rank rank) {
        matchedRank.put(rank, matchedRank.get(rank) + 1);
        totalPrize = totalPrize + rank.getPrize();
    }
}
