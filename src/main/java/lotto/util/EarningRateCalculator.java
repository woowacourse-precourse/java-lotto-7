package lotto.util;

import lotto.domain.Ranking;

import java.util.Map;

public abstract class EarningRateCalculator {

    private static final int PERCENTAGE_MULTIPLIER = 100;

    public static double calculate(int totalAmount, Map<Ranking, Integer> rankingMap) {
        int totalPrize = rankingMap.entrySet().stream()
                .mapToInt(entry -> entry.getValue() * entry.getKey().getPrize())
                .sum();

        return (totalPrize / (double) totalAmount) * PERCENTAGE_MULTIPLIER;
    }
}
