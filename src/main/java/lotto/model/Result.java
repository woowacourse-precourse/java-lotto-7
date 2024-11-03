package lotto.model;

import java.util.LinkedHashMap;
import java.util.Map;

public class Result {
    private Map<Rank, Integer> result;

    public Result() {
        result = new LinkedHashMap<>();

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

    public String getResult() {
        StringBuilder resultView = new StringBuilder();

        for (Rank rank : result.keySet()) {
            if (rank != Rank.NONE) {
                resultView.append(rank.getMessage())
                        .append(" - ")
                        .append(result.get(rank))
                        .append("개\n");
            }
        }

        return resultView.toString();
    }

    public long calculatePrize() {
        return result.entrySet().stream()
                .mapToLong(e -> (long) e.getValue() * e.getKey().getPrizeAmount())
                .sum();
    }
}
