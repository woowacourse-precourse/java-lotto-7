package lotto.domain;

import java.util.Map;

public class LottosResult {
    public static final String PURCHASE_AMOUNT = "구매금액";
    public static final String TOTAL_PRIZE = "총상금";

    private final Map<String, Integer> lottosResult;

    public LottosResult(Map<String, Integer> lottosResult) {
        this.lottosResult = lottosResult;
    }

    public double calculateReturns() {
        int usingMoney = lottosResult.get(PURCHASE_AMOUNT);
        double value = lottosResult.get(TOTAL_PRIZE) / (double) usingMoney * 100;

        return Math.round(value*10)/10.0;
    }

    public Integer get(String key) {
        return lottosResult.get(key);
    }
}
