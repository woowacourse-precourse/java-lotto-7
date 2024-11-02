package lotto.domain;

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
        return getLottoProfitSum()/ purchasePrice.getAmount() * 100;
    }

    public double getLottoProfitRate() {
        return lottoProfitRate;
    }
}
