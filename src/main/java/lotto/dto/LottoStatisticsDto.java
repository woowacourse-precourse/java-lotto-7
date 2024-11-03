package lotto.dto;

import java.util.List;
import lotto.domain.LottoRank;

public record LottoStatisticsDto(
    int firstCount,
    int secondCount,
    int thirdCount,
    int fourthCount,
    int fifthCount,
    double profitRate
) {

    public static LottoStatisticsDto of(double profitRate, List<LottoRank> ranks) {
        int firstCount = (int) ranks.stream()
            .filter(rank -> rank == LottoRank.FIRST)
            .count();
        int secondCount = (int) ranks.stream()
            .filter(rank -> rank == LottoRank.SECOND)
            .count();
        int thirdCount = (int) ranks.stream()
            .filter(rank -> rank == LottoRank.THIRD)
            .count();
        int fourthCount = (int) ranks.stream()
            .filter(rank -> rank == LottoRank.FOURTH)
            .count();
        int fifthCount = (int) ranks.stream()
            .filter(rank -> rank == LottoRank.FIFTH)
            .count();

        return new LottoStatisticsDto(firstCount, secondCount, thirdCount, fourthCount, fifthCount,
            profitRate);
    }

}
