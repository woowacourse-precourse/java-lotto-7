package lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RankCalculator {

    public Rank determineRank(int matchCount, boolean isBonusContain) {
        return Rank.valueOf(matchCount, isBonusContain);
    }

    public Map<Rank, Integer> finalRank(List<Rank> ranking){
        Map<Rank,Integer> ranks = new HashMap<>();

        for (Rank rank : Rank.values()) {
            ranks.put(rank, 0);
        }

        for (Rank rank : ranking) {
            ranks.put(rank, ranks.get(rank) + 1);
        }

        return ranks;
    }
}
