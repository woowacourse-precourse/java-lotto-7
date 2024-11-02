package lotto.domain;

public class PurchasePrice {
    private static final String PRICE_MUST_BIGGER_THAN_ZERO = "로또 구입 금액은 0원보다 커야됩니다.";
    private static final String PRICE_MUST_1000_UNIT = "로또 구입 금액은 1000원 단위여야 합니다.";
    private static final int ZERO = 0;
    public static final int UNIT = 1000;

    private final int purchasePrice;
    private final int quantity;

    public PurchasePrice(final int purchasePrice) {
        validatePurchasePrice(purchasePrice);
        this.purchasePrice = purchasePrice;
        quantity = calculateQuantity();
    }

    public int getPurchasePrice() {
        return purchasePrice;
    }

    public int getQuantity() {
        return quantity;
    }

    private void validatePurchasePrice(final int purchasePrice) {
        validateAvailableNum(purchasePrice);
        validatePriceUnit(purchasePrice);
    }

    private void validateAvailableNum(final int purchasePrice) {
        if (purchasePrice <= ZERO) {
            throw new IllegalArgumentException(PRICE_MUST_BIGGER_THAN_ZERO);
        }
    }

    private void validatePriceUnit(final int purchasePrice) {
        if (purchasePrice % PurchasePrice.UNIT != ZERO) {
            throw new IllegalArgumentException(PRICE_MUST_1000_UNIT);
        }
    }

    private int calculateQuantity() {
        return purchasePrice / UNIT;
    }

}
