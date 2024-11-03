package lotto.domain.calculator;

import lotto.domain.core.Rank;

import java.util.Map;

public class PrizeCalculator {

    public static int calculateTotalPrize(Map<Rank, Integer> rankCounts) {
        return rankCounts.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
    }
}
