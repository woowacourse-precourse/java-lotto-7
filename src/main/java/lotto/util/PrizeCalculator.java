package lotto.util;

import lotto.service.WinningResult;

import java.util.Map;

public class PrizeCalculator {

    public static int calcTotalPrizeAmount(Map<WinningResult, Integer> results) {
        int total = 0;
        for (Map.Entry<WinningResult, Integer> entry : results.entrySet()) {
            int prizeAmount = entry.getKey().getPrizeAmount();
            total += prizeAmount * entry.getValue();
        }
        return total;
    }

    public static double calcRate(int purchasePrice, int winningAmount) {
        double rate = ((double) winningAmount / purchasePrice) * 100;
        return Math.round(rate * 10) / 10.0;
    }
}
