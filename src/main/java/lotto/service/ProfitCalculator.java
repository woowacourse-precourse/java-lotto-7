package lotto.service;

import lotto.domain.LottoCounter;

public class ProfitCalculator {

    public double calculateProfitRate(LottoCounter rankCounter, int totalInvestment) {
        int totalPrize = rankCounter.getRankCounts().entrySet().stream()
                .mapToInt(entry -> entry.getValue() * entry.getKey().getPrize())
                .sum();
        return (double) totalPrize / totalInvestment * 100;
    }
}