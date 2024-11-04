package lotto.model;

import lotto.enumerate.Rank;

import java.util.Map;

public class EarningCalculator {
    public static double calculate(Map<Rank, Integer> ranks, long purchase) {
        long total = 0;
        for (Map.Entry<Rank, Integer> rankEntry : ranks.entrySet()) {
            total += rankEntry.getKey().getPrize() * rankEntry.getValue();
        }
        return total / (double) purchase * 100;
    }
}
