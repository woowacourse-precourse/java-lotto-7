package lotto.service;

import java.util.Map;

import static lotto.service.LottoResultService.PRIZES;

public class ProfitCalculatorService {

    public double calculateProfit(Map<String, Integer> results, int totalInvestment) {
        int totalWinnings = getTotalWinnings(results);
        return ((double) totalWinnings / totalInvestment) * 100;
    }

    private static int getTotalWinnings(Map<String, Integer> results) {
        return results.entrySet().stream()
                .mapToInt(entry -> {
                    String resultKey = entry.getKey();
                    Integer resultKeyCnt = entry.getValue();

                    return PRIZES.get(resultKey) * resultKeyCnt;
                })
                .sum();
    }
}