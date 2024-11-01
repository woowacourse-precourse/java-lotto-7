package lotto.model;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

public class LottoResult {
    private final Map<Rank, Integer> result = new EnumMap<>(Rank.class);

    public LottoResult() {
        for (Rank rank : Rank.values()) {
            result.put(rank, 0);
        }
    }

    public void addResult(final Rank rank) {
        result.put(rank, result.get(rank) + 1);
    }

    public double calculateReturnRate(final Money money) {
        int inputMoney = money.getAmount();
        int profit = calculatePrize();
        return ((double) profit / inputMoney) * 100;
    }

    private int calculatePrize() {
        return Rank.calculateMoney(result);
    }

    public Map<Rank, Integer> getResult() {
        return Collections.unmodifiableMap(result);
    }
}
