package lotto.domain;

import java.util.EnumMap;
import lotto.domain.constant.Ranking;

public class Profit {

    private final EnumMap<Ranking, Integer> results;
    private final int budget;

    private Profit(Result results, int budget) {
        this.results = results.getResults();
        this.budget = budget;
    }

    public static Profit from(Result results, int budget) {
        return new Profit(results, budget);
    }

    public float calculateProfitRate() {
        float profit = getTotalProfit();
        return calculateRate(profit);
    }

    private Integer getTotalProfit() {
        return results.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
    }

    private float calculateRate(float profit) {
        return (profit / budget) * 100;
    }
}
