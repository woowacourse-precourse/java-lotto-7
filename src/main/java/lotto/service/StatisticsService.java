package lotto.service;

import java.util.Map;
import lotto.model.LottoResult;

public class StatisticsService {
    public double calculateRateEarning(Map<LottoResult, Integer> lottoResultCount, int purchaseAmount) {
        int totalPrizeMoney = lottoResultCount.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrizeMoney() * entry.getValue())
                .sum();

        double rateEarning = (double) totalPrizeMoney / purchaseAmount * 100;
        return Math.round(rateEarning * 100) / 100.0;
    }
}
