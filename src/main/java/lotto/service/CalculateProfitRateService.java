package lotto.service;

import java.util.Map;
import lotto.constant.WinningRank;
import lotto.validator.LottoValidator;

public class CalculateProfitRateService {
    public static double calculateProfitRate(Map<WinningRank, Integer> results, int totalPurchaseAmount) {
        LottoValidator.validateProfitCalculation(totalPurchaseAmount);
        int totalPrize = results.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();

        return ((double) totalPrize / totalPurchaseAmount) * 100;
    }
}
