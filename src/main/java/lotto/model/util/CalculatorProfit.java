package lotto.model.util;

import java.util.Map;

public class CalculatorProfit {


    public static double calProfitRate(Map<String, Integer> status, int buyAmount) {

        double profitRate = 0.0;

        for (String key : status.keySet()) {
            int correctCount = status.get(key);
            int money = Mapping.mappingMoneyStringToMoneyInt(key);

            profitRate += correctCount * money;

        }

        if (profitRate <= 0) {
            return 0;
        }
        return profitRate / buyAmount * 100;
    }
}
