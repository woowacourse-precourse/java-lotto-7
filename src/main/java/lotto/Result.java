package lotto;

import java.util.HashMap;
import java.util.Map;

public class Result {
    private final Map<RANK, Integer> result;
    private float initCost = 0;

    Result(HashMap<RANK, Integer> result, float initCost) {
        this.result = result;
        this.initCost = initCost;
    }

    public int get(RANK rank) {
        return result.getOrDefault(rank, 0);
    }

    public double getRate() {

        double sum = result.getOrDefault(RANK.FIRST, 0) * 2000000000
                + result.getOrDefault(RANK.SECOND, 0) * 30000000
                + result.getOrDefault(RANK.THIRD, 0) * 1500000
                + result.getOrDefault(RANK.FOURTH, 0) * 50000
                + result.getOrDefault(RANK.FIFTH, 0) * 5000;
        return sum / initCost * 100;
    }
}
