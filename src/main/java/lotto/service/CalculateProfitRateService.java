package lotto.service;

import static lotto.constant.GameValue.DIVIDE_FOR_TICKET_COUNT_NUMBER;
import static lotto.constant.GameValue.PERCENTAGE;

import java.util.Map;
import lotto.constant.WinningRank;

public class CalculateProfitRateService {
    public static double calculateProfitRate(Map<WinningRank, Integer> results, int totalPurchaseAmount) {
        double totalPrize = results.entrySet().stream()
                .mapToDouble(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();

        return ((totalPrize / DIVIDE_FOR_TICKET_COUNT_NUMBER.getValue()) / totalPurchaseAmount) * PERCENTAGE.getValue();
    }
}
