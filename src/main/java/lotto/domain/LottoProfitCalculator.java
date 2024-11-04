package lotto.domain;

import java.util.EnumMap;

import static java.lang.String.format;

public class LottoProfitCalculator {

    private static final int PERCENT_CONVERSION_FACTOR = 100;
    private static final String DECIMAL_FORMAT = "%.1f";

    private final String lottoProfitRate;

    private LottoProfitCalculator(EnumMap<LottoRankType, Integer> rankCountMap, final int purchaseAmount) {
        this.lottoProfitRate = calculateProfitRate(rankCountMap, purchaseAmount);
    }

    public static LottoProfitCalculator from(EnumMap<LottoRankType, Integer> rankCountMap, final int purchaseAmount) {
        return new LottoProfitCalculator(rankCountMap, purchaseAmount);
    }

    public String getLottoProfitRate() {
        return lottoProfitRate;
    }

    private String calculateProfitRate(EnumMap<LottoRankType, Integer> rankCountMap, final int purchaseAmount) {
        double totalProfit = rankCountMap.entrySet().stream()
                .mapToDouble(entry -> entry.getKey().getPrice() * entry.getValue())
                .sum();
        return format(DECIMAL_FORMAT, (totalProfit / purchaseAmount) * PERCENT_CONVERSION_FACTOR);
    }

}