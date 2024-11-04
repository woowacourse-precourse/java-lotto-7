package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Result {
    private Map<Rank, Integer> ranks = new HashMap<>();

    public Result(List<Rank> ranks) {
        for (Rank rank : ranks) {
            this.ranks.put(rank, this.ranks.getOrDefault(rank, 0) + 1);
        }
    }
}
