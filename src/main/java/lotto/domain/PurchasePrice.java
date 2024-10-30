package lotto.domain;

public class PurchasePrice {
    private static final int UNIT = 1000;

    private final int purchasePrice;
    private final int quantity;

    public PurchasePrice(int purchasePrice) {
        this.purchasePrice = purchasePrice;
        quantity = calculateQuantity();
    }

    private int calculateQuantity() {
        return purchasePrice / UNIT;
    }

    public int getPurchasePrice() {
        return purchasePrice;
    }

    public int getQuantity() {
        return quantity;
    }
}
