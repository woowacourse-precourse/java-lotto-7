package model.result;

import java.util.HashMap;
import java.util.Map;
import model.money.Money;

public class RankResult {

    private final Map<Rank, Integer> result;

    private RankResult(Map<Rank, Integer> result) {
        this.result = result;
    }

    public static RankResult initiate() {
        Map<Rank, Integer> result = new HashMap<>();
        Rank.ranksExceptNone()
                .forEach(rank -> result.put(rank, 0));
        return new RankResult(result);
    }

    public void compute(Rank rank) {
        result.computeIfPresent(rank, (status, value) -> value + 1);
    }

    public Money calculateTotalPrize() {
        long totalPrizeValue = result.entrySet()
                .stream()
                .mapToLong(entry -> (long) entry.getKey().getPrize() * entry.getValue())
                .sum();
        return Money.from(totalPrizeValue);
    }
}
