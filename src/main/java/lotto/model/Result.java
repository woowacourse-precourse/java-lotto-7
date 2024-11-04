package lotto.model;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.util.NumberToString;

public class Result {
    private static final int PERCENTAGE_RATIO = 100;

    Map<Prize, Integer> result;

    public Result(Map<Prize, Integer> result) {
        nullToZero(result);
        this.result = result;
    }

    private void nullToZero(Map<Prize, Integer> result) {
        Arrays.stream(Prize.values())
                .forEach(prize -> result.putIfAbsent(prize, 0));
    }

    public String toString() {
        return Arrays.stream(Prize.values())
                .map(prize -> String.format("%s - %d개",
                        prize,
                        result.get(prize)))
                .collect(Collectors.joining("\n"));
    }

    public String calculateProfitRate(int purchaseAmount) {
        return NumberToString.decimalToString(
                (double) totalMoney() / purchaseAmount * PERCENTAGE_RATIO);
    }

    private int totalMoney() {
        return Arrays.stream(Prize.values())
                .mapToInt(prize -> prize.calculateResult(result.get(prize)))
                .sum();
    }
}
