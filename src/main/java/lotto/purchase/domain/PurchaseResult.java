package lotto.purchase.domain;

public class PurchaseResult {
    private final Purchase purchase;
    private final double rateOfReturn;

    private PurchaseResult(Purchase purchase, double rateOfReturn) {
        this.purchase = purchase;
        this.rateOfReturn = rateOfReturn;
    }

    public static PurchaseResult of(Purchase purchase) {
        long totalValue = purchase.getLottoResults().calculateTotalWinningAmount();
        double rateOfReturn = purchase.getMoney().calculateRateOfIncome(totalValue);
        return new PurchaseResult(purchase, rateOfReturn);
    }

    public Purchase getPurchase() {
        return purchase;
    }

    public double getRateOfReturn() {
        return rateOfReturn;
    }
}
