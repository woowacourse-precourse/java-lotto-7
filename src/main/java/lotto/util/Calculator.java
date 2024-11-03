package lotto.util;

import java.util.Map;
import lotto.model.Result;

public class Calculator {
    public static int calculateLottoTicketNumber(int input) {
        return input / 1000;
    }

    public static String calculateProfit(int lottoAmount, Map<Result, Integer> results) {
        float totalProfit = 0;

        for (Result result : results.keySet()) {
            totalProfit += result.getPrizeMoney() * results.get(result);
        }

        totalProfit /= lottoAmount;
        return String.format("%.1f", totalProfit * 100);
    }
}
