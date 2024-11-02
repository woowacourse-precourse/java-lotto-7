package lotto.lotto;

import java.util.Map;

public class LottoGame {

    private static final double ROUNDING_SCALE = 10.0;
    private static final int PERCENTAGE = 100;

    public double calculateProfit(Map<Rank, Integer> rankSummary, LottoAmount lottoAmount) {
        int totalAmount = getTotalAmount(rankSummary);
        double profit = (double) totalAmount / lottoAmount.getAmount() * PERCENTAGE;
        return Math.round(profit * ROUNDING_SCALE) / ROUNDING_SCALE;
    }

    private int getTotalAmount(Map<Rank, Integer> rankSummary) {
        return rankSummary.keySet().stream()
                .mapToInt(rank -> rank.calculateRankAmount(rankSummary.get(rank)))
                .sum();
    }
}
