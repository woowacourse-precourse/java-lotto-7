package lotto.lotto;

import java.util.Map;

public class LottoGame {

    private static final int PERCENTAGE = 100;

    public double calculateProfit(Map<Rank, Integer> rankSummary, LottoAmount lottoAmount) {
        int totalAmount = getTotalAmount(rankSummary);
        return (double) totalAmount / lottoAmount.getAmount() * PERCENTAGE;
    }

    private int getTotalAmount(Map<Rank, Integer> rankSummary) {
        return rankSummary.keySet().stream()
                .mapToInt(rank -> rank.calculateRankAmount(rankSummary.get(rank)))
                .sum();
    }
}
