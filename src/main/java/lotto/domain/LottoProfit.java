package lotto.domain;

public class LottoProfit {
    private final double profit;
    private final int lottoPurchasePrice;

    private LottoProfit(double profit, int lottoPurchasePrice){
        this.profit = profit;
        this.lottoPurchasePrice = lottoPurchasePrice;
    }

    public static LottoProfit ofProfitAndLottoPurchasePrice(double profit, int lottoPurchasePrice){
        return new LottoProfit(profit, lottoPurchasePrice);
    }

    public double getProfitRate(){
        return (profit / lottoPurchasePrice) * 100;
    }
}
