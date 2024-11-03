package lotto.model;

import java.util.Map;
import lotto.config.LottoRank;
import lotto.vo.BuyLottoAmount;

public class YieldRate {
    private static final Integer DEFAULT_PERCENTAGE = 100;

    private final Double rate;

    private YieldRate(Double rate) {
        this.rate = rate;
    }

    public static YieldRate createYieldRate(final Map<LottoRank, Integer> result,
                                            final BuyLottoAmount buyLottoAmount) {
        return new YieldRate(calculateYieldRate(result, buyLottoAmount));
    }

    private static Double calculateYieldRate(final Map<LottoRank, Integer> result,
                                             final BuyLottoAmount buyLottoAmount) {
        double reward = result.keySet()
                .stream()
                .mapToDouble(lottoRank -> calculateEachRankReward(result, lottoRank))
                .sum();

        return (reward / (double) buyLottoAmount.amount()) * DEFAULT_PERCENTAGE;
    }

    private static Long calculateEachRankReward(Map<LottoRank, Integer> result,
                                                final LottoRank lottoRank) {
        return lottoRank.getPrizeMoney() * result.get(lottoRank);
    }

    public Double getRate() {
        return rate;
    }
}
