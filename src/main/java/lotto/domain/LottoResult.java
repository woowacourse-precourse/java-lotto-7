package lotto.domain;

import lotto.common.constant.LottoPrizeRank;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

public class LottoResult {
    private static final int LOTTO_PRICE = 1000;
    private final Map<LottoPrizeRank, Integer> rankCount;
    private final int totalTickets;

    public LottoResult(Map<LottoPrizeRank, Integer> rankCount, int totalTickets) {
        this.rankCount = new EnumMap<>(LottoPrizeRank.class);
        rankCount.forEach(this.rankCount::put);
        this.totalTickets = totalTickets;
    }

    public Map<LottoPrizeRank, Integer> getWinningStatistics() {
        return Collections.unmodifiableMap(rankCount);
    }

    public double calculateProfitRate() {
        long totalPrize = calculateTotalPrize();
        long totalCost = (long) totalTickets * LOTTO_PRICE;
        return Math.round((totalPrize * 100.0) / totalCost * 10.0) / 10.0;
    }

    private long calculateTotalPrize() {
        return rankCount.entrySet().stream()
                .mapToLong(entry -> entry.getKey().getPrizeMoney() * entry.getValue())
                .sum();
    }
}