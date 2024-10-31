package lotto.domain;

import java.util.Map;

public class LottoResult {
    private final Map<Ranking, Integer> lottoResults;
    private final Long totalPrize;
    private final double revenue;

    private LottoResult(Map<Ranking, Integer> lottoResults, Long totalPrize, double revenue) {
        this.lottoResults = lottoResults;
        this.totalPrize = totalPrize;
        this.revenue = revenue;
    }

    public static LottoResult from(Map<Ranking, Integer> lottoResults, Long lottoPurchaseMoney) {
        Long totalPrize = calculateTotalPrize(lottoResults);
        double revenue = calculateRevenue(totalPrize, lottoPurchaseMoney);
        return new LottoResult(lottoResults, totalPrize, revenue);
    }

    private static Long calculateTotalPrize(Map<Ranking, Integer> lottoResults) {
        return lottoResults.keySet().stream()
                .mapToLong(key -> (long) key.getPrize() * lottoResults.get(key))
                .sum();
    }

    private static double calculateRevenue(Long totalPrize, Long lottoPurchaseMoney) {
        return (double) totalPrize / lottoPurchaseMoney * 100;
    }

    public Map<Ranking, Integer> getLottoResults() {
        return lottoResults;
    }

    public Long getTotalPrize() {
        return totalPrize;
    }

    public double getRevenue() {
        return revenue;
    }
}

