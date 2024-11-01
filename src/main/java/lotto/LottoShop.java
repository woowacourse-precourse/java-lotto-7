package lotto;

public class LottoShop {

    public int calculatePurchaseCount(PurchaseAmount purchaseAmount) {
        return purchaseAmount.divideLottoPrice();
    }
}
