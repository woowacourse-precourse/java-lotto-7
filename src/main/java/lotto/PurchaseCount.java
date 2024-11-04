package lotto;

public class PurchaseCount {
    private static final int LOTTO_PRICE = 1000;
    private final int purchaseCount;

    public PurchaseCount(int purchaseAmount) {
        this.purchaseCount = purchaseAmount / LOTTO_PRICE;
    }

    public int getPurchaseCount() {
        return purchaseCount;
    }
}