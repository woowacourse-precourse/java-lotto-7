package lotto.model;

import java.util.HashMap;
import java.util.Map;

public class Result {
    private Map<Rank, Integer> result;

    public Result() {
        result = new HashMap<>();

        initializeResult();
    }

    private void initializeResult() {
        for (Rank rank : Rank.values()) {
            result.put(rank, 0);
        }
    }

    public void updateResult(Rank rank) {
        int current = result.get(rank);
        result.put(rank, current + 1);
    }
}
