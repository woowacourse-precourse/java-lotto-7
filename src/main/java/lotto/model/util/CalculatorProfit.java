package lotto.model.util;

import java.util.Map;

public class CalculatorProfit {


    public static double calProfitRate(Map<String, Integer> status, int buyAmount) {

        long profitRate = 0L;

        for (String key : status.keySet()) {
            int correctCount = status.get(key);
            int money = Mapping.mappingMoneyStringToMoneyInt(key);

            profitRate += correctCount * money;

        }

        if (profitRate <= 0) {
            return 0;
        }
        return ((double) profitRate / buyAmount) * 100;
    }
}
