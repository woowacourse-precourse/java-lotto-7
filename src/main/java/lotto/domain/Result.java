package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class Result {
    public final Map<Integer, Integer> numbers;

    public Result(int size) {
        numbers = new HashMap<>();

        for (int i = size; i >= 0; i--) {
            numbers.put(i, 0);
        }
    }

    public void addResult(int rank) {
        numbers.put(rank, numbers.get(rank) + 1);
    }

    public Map<Integer, Integer> getResult() {
        return numbers;
    }
}
