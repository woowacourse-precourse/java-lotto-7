package lotto.domain;

public class LottoProfit {
    private final double profit;
    private final int lottoPurchasePrice;

    public LottoProfit(double profit, int lottoPurchasePrice){
        this.profit = profit;
        this.lottoPurchasePrice = lottoPurchasePrice;
    }

    public double getProfitRate(){
        return (profit / lottoPurchasePrice) * 100;
    }
}
