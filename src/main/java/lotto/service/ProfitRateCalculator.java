package lotto.service;

import java.text.DecimalFormat;
import java.util.Map;
import lotto.domain.PurchasePrice;
import lotto.domain.Ranking;

public class ProfitRateCalculator {

    public double calculateProfitRate(PurchasePrice purchasePrice, Map<Ranking, Integer> results) {
        double totalPrizeAmount = results.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrizeAmount() * entry.getValue())
                .sum();

        return (totalPrizeAmount / purchasePrice.getPurchasePrice()) * 100;
    }
}
