package lotto.domain;

import static lotto.constants.LottoConstant.PROFIT_RATE;

public class LottoProfitRate {

    private double lottoProfitRate;

    public LottoProfitRate(double lottoProfitRate) {
        this.lottoProfitRate = lottoProfitRate;
    }

    public static LottoProfitRate of(PurchasePrice purchasePrice) {
        double lottoProfit = getLottoProfit(purchasePrice);
        return new LottoProfitRate(lottoProfit);
    }

    private static double getLottoProfitSum() {
        long sum = 0;
        for (Rank rank : Rank.values()) {
            sum += (long) rank.getPrize() * rank.getCount();
        }
        return (double) sum;
    }

    private static double getLottoProfit(PurchasePrice purchasePrice) {
        return getLottoProfitSum() / purchasePrice.getAmount() * PROFIT_RATE;
    }

    public double getLottoProfitRate() {
        return lottoProfitRate;
    }
}
