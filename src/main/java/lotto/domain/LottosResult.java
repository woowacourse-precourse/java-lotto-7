package lotto.domain;

import java.util.Map;

public class LottosResult {
    private final Map<String, Integer> lottosResult;

    public LottosResult(Map<String, Integer> lottosResult) {
        this.lottosResult = lottosResult;
    }

    public double calculateReturns() {
        int usingMoney = lottosResult.get("구매금액");
        double value = lottosResult.get("총상금") / (double) usingMoney * 100;

        return Math.round(value*10)/10.0;
    }

    public Integer get(String key) {
        return lottosResult.get(key);
    }
}
