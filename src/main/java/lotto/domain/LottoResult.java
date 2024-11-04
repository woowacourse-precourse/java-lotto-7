package lotto.domain;

import java.util.EnumMap;
import lotto.domain.vo.LottoRank;

public class LottoResult {
    private final EnumMap<LottoRank, Integer> rankCounts;

    private LottoResult(EnumMap<LottoRank, Integer> rankCounts) {
        this.rankCounts = rankCounts;
    }

    public static LottoResult of(EnumMap<LottoRank, Integer> rankCounts) {
        return new LottoResult(rankCounts);
    }

    public Integer getCountByRank(LottoRank lottoRank) {
        return rankCounts.getOrDefault(lottoRank, 0);
    }

    public Double calculateProfitRate(Integer purchaseAmount) {
        double rate = (calculateTotalPrize() / (double) purchaseAmount) * 100;
        return Math.round(rate * 10.0) / 10.0;
    }

    private Long calculateTotalPrize() {
        return rankCounts.keySet()
                .stream()
                .mapToLong(rank -> (long) rankCounts.get(rank) * rank.getPrize())
                .sum();
    }
}
