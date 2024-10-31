package lotto.logic;

import java.util.Map;

public class LottoResultEvaluator {

    private Map<Integer, Integer> result;
    private int profit;
    private double returnRate;

    public Map<Integer, Integer> getResult() {
        return result;
    }

    public int getProfit() {
        return profit;
    }

    public double getReturnRate() {
        return returnRate;
    }
}
