package lotto.domain;

public class PurchasePrice {
    private static final String PRICE_MUST_BIGGER_THAN_ZERO = "로또 구입 금액은 0원보다 커야됩니다.";
    private static final String PRICE_MUST_1000_UNIT = "로또 구입 금액은 1000원 단위여야 합니다.";
    private static final int ZERO = 0;
    private static final int UNIT = 1000;

    private final int purchasePrice;

    public PurchasePrice(int purchasePrice) {
        this.purchasePrice = purchasePrice;
        validateAvailableNum();
        validatePriceUnit();
    }

    private void validateAvailableNum() {
        if (purchasePrice <= ZERO) {
            throw new IllegalArgumentException(PRICE_MUST_BIGGER_THAN_ZERO);
        }
    }

    private void validatePriceUnit() {
        if (purchasePrice % UNIT != ZERO) {
            throw new IllegalArgumentException(PRICE_MUST_1000_UNIT);
        }
    }

    public int getPurchasePrice() {
        return purchasePrice;
    }
}
