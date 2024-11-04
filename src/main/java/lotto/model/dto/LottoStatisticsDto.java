package lotto.model.dto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.model.domain.LottoRank;

public class LottoStatisticsDto {
    private final List<LottoRankCount> sortedRankCounts;
    private final double profitRate;

    public LottoStatisticsDto(List<LottoRank> lottoResults, int purchaseAmount) {
        this.sortedRankCounts = calculateSortedRankCounts(lottoResults);
        this.profitRate = calculateProfitRate(purchaseAmount);
    }

    private List<LottoRankCount> calculateSortedRankCounts(List<LottoRank> lottoResults) {
        List<LottoRank> ranks = new ArrayList<>(List.of(LottoRank.values()));
        Collections.reverse(ranks);  // 역순으로 변환

        return ranks.stream()
                .filter(rank -> rank != LottoRank.FAIL) // FAIL 제외
                .map(rank -> new LottoRankCount(rank, (int) lottoResults.stream()
                        .filter(result -> result == rank)
                        .count()))
                .toList();
    }


    private double calculateProfitRate(int purchaseAmount) {
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
