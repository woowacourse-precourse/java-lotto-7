package lotto.domain;

import java.util.List;

import static java.lang.String.format;

public class LottoProfitCalculator {

    private static final int PERCENT_CONVERSION_FACTOR = 100;
    private static final String DECIMAL_FORMAT = "%.1f";

    private final String lottoProfitRate;

    private LottoProfitCalculator(List<LottoRankType> lottoRankTypes, final int purchaseAmount) {
        this.lottoProfitRate = calculateProfitRate(lottoRankTypes, purchaseAmount);
    }

    public static LottoProfitCalculator from(List<LottoRankType> lottoRankTypes, final int purchaseAmount) {
        return new LottoProfitCalculator(lottoRankTypes, purchaseAmount);
    }

    public String getLottoProfitRate() {
        return lottoProfitRate;
    }

    private String calculateProfitRate(List<LottoRankType> lottoRankTypes, final int purchaseAmount) {
        double profitRate = lottoRankTypes.stream()
                .mapToDouble(LottoRankType::getPrice)
                .sum();
        return format(DECIMAL_FORMAT, (profitRate / purchaseAmount) * PERCENT_CONVERSION_FACTOR);
    }

}