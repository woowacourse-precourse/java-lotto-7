package lotto.model;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoStatistics {

    private final Map<LottoRank, Integer> rankCounts;

    private final double profitRate;

    public LottoStatistics(List<LottoRank> lottoResult, int purchasePrice) {
        this.rankCounts = calculateRankCounts(lottoResult);
        this.profitRate = calculateProfitRate(purchasePrice);
    }

    public Map<LottoRank, Integer> getRankCounts() {
        return rankCounts;
    }

    public double getProfitRate() {
        return profitRate;
    }

    private double calculateProfitRate(int purchasePrice) {
        double totalPrize = rankCounts.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();

        return Math.round(totalPrize * 100 / purchasePrice);
    }

    private Map<LottoRank, Integer> calculateRankCounts(List<LottoRank> lottoResult) {
        Map<LottoRank, Integer> rankCounts = new EnumMap<>(LottoRank.class);
        for (LottoRank lottoRank : LottoRank.values()) {
            rankCounts.put(lottoRank, (int) lottoResult.stream().filter(rank -> rank == lottoRank).count());
        }
        return rankCounts;
    }
}
