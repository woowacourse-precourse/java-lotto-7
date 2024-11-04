package lotto.domain;

import static lotto.domain.Lotto.LOTTO_PRICE;

import java.util.Map;

public class LottoResult {
    private final Map<Ranking, Integer> result;
    private final double revenue;

    private LottoResult(Map<Ranking, Integer> result, double revenue) {
        this.result = result;
        this.revenue = revenue;
    }

    public static LottoResult from(Map<Ranking, Integer> lottoResults) {
        double revenue = calculateRevenue(lottoResults);
        return new LottoResult(lottoResults, revenue);
    }

    private static double calculateRevenue(Map<Ranking, Integer> lottoResults) {
        int purchasedLottoCount = calculatePurchasedLottoCount(lottoResults);
        Money investmentMoney = LOTTO_PRICE.multiply(purchasedLottoCount);
        Money totalPrize = Money.from(calculateTotalPrize(lottoResults));

        return totalPrize.calculateRevenue(investmentMoney);
    }

    private static int calculatePurchasedLottoCount(Map<Ranking, Integer> lottoResults) {
        return lottoResults.values().stream()
                .mapToInt(lottoCount -> lottoCount)
                .sum();
    }

    private static Long calculateTotalPrize(Map<Ranking, Integer> lottoResults) {
        return lottoResults.entrySet().stream()
                .mapToLong(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
    }


    public Map<Ranking, Integer> getResults() {
        return result;
    }

    public double getRevenue() {
        return revenue;
    }
}

