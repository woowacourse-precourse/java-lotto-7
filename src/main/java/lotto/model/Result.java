package lotto.model;

import static lotto.util.Constants.ZERO;
import static lotto.util.Constants.COUNT;
import static lotto.util.Constants.RANK_DELIMITER;
import static lotto.util.Constants.LINE_SEPARATOR;

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
            result.put(rank, ZERO);
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
                        .append(RANK_DELIMITER)
                        .append(result.get(rank))
                        .append(COUNT + LINE_SEPARATOR);
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
