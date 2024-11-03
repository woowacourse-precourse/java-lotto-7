package lotto;

public class PurchaseCount {
    int purchaseCount;

    public PurchaseCount(int purchaseAmount) {
        this.purchaseCount = purchaseAmount / 1000;
    }

    public int getPurchaseCount() {
        return purchaseCount;
    }
}
