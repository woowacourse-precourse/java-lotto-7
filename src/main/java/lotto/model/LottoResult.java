package lotto.model;

import java.util.Map;

public class LottoResult {

    private final Map<Prize, Integer> prizeResults;
    private final int totalPrizeAmount;

    public LottoResult(Map<Prize, Integer> prizeResults) {
        this.prizeResults = prizeResults;
        this.totalPrizeAmount = calculateTotalPrizeAmount();
    }

    private int calculateTotalPrizeAmount() {
        return prizeResults.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrizeAmount() * entry.getValue())
                .sum();
    }

    public double calculateYield(int totalPurchaseAmount) {
        return ((double) totalPrizeAmount / totalPurchaseAmount) * 100;
    }

    public Map<Prize, Integer> getPrizeResults() {
        return prizeResults;
    }
}
