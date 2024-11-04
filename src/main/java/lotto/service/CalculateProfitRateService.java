package lotto.service;

import java.util.Map;
import lotto.constant.WinningRank;

public class CalculateProfitRateService {
    public static double calculateProfitRate(Map<WinningRank, Integer> results, int totalPurchaseAmount) {
        double totalPrize = results.entrySet().stream()
                .mapToDouble(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
        
        return ((totalPrize / 1000) / totalPurchaseAmount) * 100;
    }
}
