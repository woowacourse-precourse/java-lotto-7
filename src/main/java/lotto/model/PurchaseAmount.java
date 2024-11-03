package lotto.model;

public class PurchaseAmount {
    private static final int LOTTO_TICKET_PRICE = 1000;
    private final int purchaseAmount;

    private PurchaseAmount(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public static PurchaseAmount from(int purchaseAmount) {
        return new PurchaseAmount(purchaseAmount);
    }

    public int calculateQuantity() {
        return purchaseAmount / LOTTO_TICKET_PRICE;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }
}
