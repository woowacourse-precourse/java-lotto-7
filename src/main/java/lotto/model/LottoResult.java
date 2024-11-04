package lotto.model;

import static lotto.constant.LottoConstants.*;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public final class LottoResult {
    private final Map<Rank, Integer> result = new TreeMap<>();

    public LottoResult() {
        Arrays.stream(Rank.values())
                .forEach(rank -> result.put(rank, INITIAL_COUNTER_NUMBER));
    }

    public void putResult(Rank rank) {
        result.merge(rank, COUNTER_STEP, Integer::sum);
    }

    public double computeProfit(long amount) {
        double profit = (double) computeTotalPrice() / amount;
        return convertPercent(profit);
    }

    private double convertPercent(double profit) {
        return profit * PERCENTAGE_SCALE;
    }

    public long computeTotalPrice() {
        return result.entrySet().stream()
                .mapToLong(resultEntry -> resultEntry.getKey().getPrice() * resultEntry.getValue())
                .sum();
    }

    public Map<Rank, Integer> getResult() {
        return result;
    }
}
