package lotto.model;

import java.util.Arrays;
import java.util.Map;

public class Result {
    Map<Prize, Integer> result;

    public Result(Map<Prize, Integer> result) {
        nullToZero(result);
        this.result = result;
    }

    private void nullToZero(Map<Prize, Integer> result) {
        Arrays.stream(Prize.values())
                .forEach(prize -> result.putIfAbsent(prize, 0));
    }

    public int totalMoney() {
        return Arrays.stream(Prize.values())
                .mapToInt(prize -> prize.calculateResult(result.get(prize)))
                .sum();
    }
}
