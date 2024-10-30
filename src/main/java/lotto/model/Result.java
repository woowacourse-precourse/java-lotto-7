package lotto.model;

import java.util.Arrays;
import java.util.Map;

public class Result {
    Map<Prize, Integer> result;

    public Result(Map<Prize, Integer> result) {
        this.result = nullToZero(result);
    }

    private Map<Prize, Integer> nullToZero(Map<Prize, Integer> result) {
        Arrays.stream(Prize.values())
                .forEach(prize -> result.putIfAbsent(prize, 0));

        return result;
    }

    public int totalMoney() {
        return Arrays.stream(Prize.values())
                .mapToInt(prize -> prize.calculateResult(result.get(prize)))
                .sum();
    }
}
