package lotto.service;

import java.util.List;
import lotto.domain.LottoRank;
import lotto.dto.LottoStatisticsDto;

public class LottoStatisticsService {

    public LottoStatisticsDto getLottoStatistics(List<LottoRank> lottoRanks, int purchaseAmount) {
        double profitRate = calculateProfitRate(lottoRanks, purchaseAmount);

        return LottoStatisticsDto.of(profitRate, lottoRanks);
    }

    public double calculateProfitRate(List<LottoRank> ranks, int purchaseAmount) {
        int totalPrize = sumPrize(ranks);
        double profitRate = totalPrize / (double) purchaseAmount * 100;

        return roundToTwoDecimalPlaces(profitRate);
    }

    private int sumPrize(List<LottoRank> ranks) {
        return ranks.stream()
            .mapToInt(LottoRank::getPrize)
            .sum();
    }

    private double roundToTwoDecimalPlaces(double profitRate) {
        return Math.round(profitRate * 10) / 10.0;
    }
}
