package lotto.model;

import java.util.Comparator;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoStatisticsDto {
    private final List<Map.Entry<LottoRank, Integer>> sortedRankCounts;
    private final double profitRate;

    public LottoStatisticsDto(List<LottoRank> lottoResults, int purchaseAmount) {
        this.sortedRankCounts = calculateSortedRankCounts(lottoResults);
        this.profitRate = calculateProfitRate(sortedRankCounts, purchaseAmount);
    }

    private List<Map.Entry<LottoRank, Integer>> calculateSortedRankCounts(List<LottoRank> lottoResults) {
        Map<LottoRank, Integer> rankCounts = new EnumMap<>(LottoRank.class);

        for (LottoRank lottoRank : LottoRank.values()) {
            rankCounts.put(lottoRank, (int) lottoResults.stream().filter(rank -> rank == lottoRank).count());
        }

        return rankCounts.entrySet().stream()
                .filter(entry -> entry.getKey() != LottoRank.FAIL) // FAIL 제외
                .sorted(Comparator.comparingInt(entry -> -entry.getKey().getMatchCount())) // matchCount로 내림차순 정렬
                .toList();
    }

    private double calculateProfitRate(List<Map.Entry<LottoRank, Integer>> sortedRankCounts, int purchaseAmount) {
        int totalPrize = sortedRankCounts.stream()
                .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
        return (double) totalPrize / purchaseAmount * 100;
    }

    public List<Map.Entry<LottoRank, Integer>> getSortedRankCounts() {
        return sortedRankCounts;
    }

    public double getProfitRate() {
        return profitRate;
    }
}
