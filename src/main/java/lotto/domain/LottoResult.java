package lotto.domain;

import java.util.Map;

public class LottoResult {
    private final Map<Ranking, Integer> result;
    private final double revenue;

    private LottoResult(Map<Ranking, Integer> result, double revenue) {
        this.result = result;
        this.revenue = revenue;
    }

    public static LottoResult of(Map<Ranking, Integer> lottoResults, Money baseMoney) {
        Money totalPrize = Money.from(calculateTotalPrize(lottoResults));
        return new LottoResult(lottoResults, totalPrize.calculateRevenue(baseMoney));
    }

    private static Long calculateTotalPrize(Map<Ranking, Integer> lottoResults) {
        return lottoResults.keySet().stream()
                .mapToLong(key -> (long) key.getPrize() * lottoResults.get(key))
                .sum();
    }

    public Map<Ranking, Integer> getResults() {
        return result;
    }

    public double getRevenue() {
        return revenue;
    }
}

