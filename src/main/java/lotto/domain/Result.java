package lotto.domain;

import java.util.Map;

public class Result {

    private final Map<Prize, Integer> prizeCount;
    private final float returnRate;

    public Result(Map<Prize, Integer> prize, float returnRate) {
        this.prizeCount = prize;
        this.returnRate = returnRate;
    }

    public Map<Prize, Integer> getImmutablePrizeCount() {
        return Map.copyOf(prizeCount);
    }

    public float getReturnRate() {
        return returnRate;
    }
}
