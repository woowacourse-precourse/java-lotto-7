package lotto.domain;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

public class TotalResult {

    private final EnumMap<Reward, Integer> totalResult;

    public TotalResult(EnumMap<Reward, Integer> totalResult) {
        this.totalResult = totalResult;
    }

    public Map<Reward, Integer> getUnmodifiableTotalResult() {
        return Collections.unmodifiableMap(totalResult);
    }

    public long calcSumOfPrize() {
        return totalResult.entrySet().stream()
                .mapToLong(entry -> entry.getKey().getPrizeAmount() * entry.getValue())
                .sum();
    }
}
