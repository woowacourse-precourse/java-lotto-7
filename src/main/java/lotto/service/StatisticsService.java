package lotto.service;

import java.util.Map;
import lotto.constant.LottoConstants;
import lotto.model.LottoResult;

public class StatisticsService {

    public double calculateRateEarning(Map<LottoResult, Integer> lottoResultCount, int purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);
        int totalPrizeMoney = calculateTotalPrizeMoney(lottoResultCount);
        return calculateRateEarningPercentage(totalPrizeMoney, purchaseAmount);
    }

    private void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount <= 0) {
            throw new IllegalArgumentException(LottoConstants.ERROR_PURCHASE_AMOUNT_GREATER_THAN_ZERO);
        }
    }

    private int calculateTotalPrizeMoney(Map<LottoResult, Integer> lottoResultCount) {
        return lottoResultCount.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrizeMoney() * entry.getValue())
                .sum();
    }

    private double calculateRateEarningPercentage(int totalPrizeMoney, int purchaseAmount) {
        double rateEarning = ((double) totalPrizeMoney / purchaseAmount) * 100;
        return Math.round(rateEarning * 100) / 100.0;  // 소수점 둘째 자리까지 반올림
    }
}
