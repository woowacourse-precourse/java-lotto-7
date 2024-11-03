package lotto.domain;

import static lotto.constants.LottoConstant.PROFIT_RATE;

public class LottoProfitRate {

    private double lottoProfitRate;

    public LottoProfitRate(PurchasePrice purchasePrice){
        lottoProfitRate = getLottoProfit(purchasePrice);
    }

    private static double getLottoProfitSum(){
        double sum = 0;
        for(Rank rank: Rank.values()){
            sum += rank.getPrize() * rank.getCount();
        }
        return sum;
    }

    private static double getLottoProfit(PurchasePrice purchasePrice){
        return getLottoProfitSum()/ purchasePrice.getAmount() * PROFIT_RATE;
    }

    public double getLottoProfitRate() {
        return lottoProfitRate;
    }
}
