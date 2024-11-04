package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoStatisticsDto {
    private final List<LottoRankCount> sortedRankCounts;
    private final double profitRate;

    public LottoStatisticsDto(List<LottoRank> lottoResults, int purchaseAmount) {
        this.sortedRankCounts = calculateSortedRankCounts(lottoResults);
        this.profitRate = calculateProfitRate(sortedRankCounts, purchaseAmount);
    }

    private List<LottoRankCount> calculateSortedRankCounts(List<LottoRank> lottoResults) {
        List<LottoRankCount> rankCounts = new ArrayList<>();

        for (LottoRank lottoRank : LottoRank.values()) {
            if (lottoRank == LottoRank.FAIL) {
                continue; // FAIL 제외
            }

            int count = (int) lottoResults.stream()
                    .filter(rank -> rank == lottoRank)
                    .count();

            rankCounts.add(new LottoRankCount(lottoRank, count));
        }

        return rankCounts;
    }

    private double calculateProfitRate(List<LottoRankCount> sortedRankCounts, int purchaseAmount) {
        int totalPrize = sortedRankCounts.stream()
                .mapToInt(entry -> entry.rank().getPrize() * entry.count())
                .sum();
        return (double) totalPrize / purchaseAmount * 100;
    }

    public List<LottoRankCount> getSortedRankCounts() {
        return sortedRankCounts;
    }

    public double getProfitRate() {
        return profitRate;
    }
}
