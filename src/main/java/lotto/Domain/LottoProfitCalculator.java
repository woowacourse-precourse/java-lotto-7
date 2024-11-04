package lotto.Domain;

public class LottoProfitCalculator {
    private static final int PERCENTAGE = 100;
    private static final double ROUND_SCALE = 10.0;

    public double calculateProfitRate(LottoResult lottoResult, int purchaseAmount) {
        long totalPrize = calculateTotalPrize(lottoResult);
        return Math.round(((double) totalPrize / purchaseAmount) * PERCENTAGE * ROUND_SCALE) / ROUND_SCALE;
    }

    private long calculateTotalPrize(LottoResult lottoResult) {
        return lottoResult.getResults().entrySet().stream()
                .mapToLong(entry -> (long) entry.getKey().prize * entry.getValue())
                .sum();
    }
}

