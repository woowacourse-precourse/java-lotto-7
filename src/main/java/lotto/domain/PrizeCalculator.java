package lotto.domain;

import java.util.Map;

public class PrizeCalculator {

    public static int calculateTotalPrize(Map<Rank, Integer> rankCounts) {
        return rankCounts.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrize().getPrize() * entry.getValue())
                .sum();
    }
}
