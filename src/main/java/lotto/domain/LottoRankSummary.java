package lotto.domain;

import java.util.EnumMap;

public class LottoRankSummary {

    private final EnumMap<LottoRank, Integer> rankCounts = new EnumMap<>(LottoRank.class);

    public LottoRankSummary() {
        for (LottoRank rank : LottoRank.values()) {
            rankCounts.put(rank, 0);
        }
    }

    public void incrementCount(LottoRank rank) {
        rankCounts.put(rank, rankCounts.get(rank) + 1);
    }

    public double calculateRateOfReturn(PurchaseAmount purchaseAmount) {
        int totalPrize = calculateTotalPrize();
        return purchaseAmount.findRateOfReturn(totalPrize);
    }

    private int calculateTotalPrize() {
        return rankCounts.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrizeAmount() * entry.getValue())
                .sum();
    }

    public EnumMap<LottoRank, Integer> getRankCounts() {
        return this.rankCounts;
    }
}
