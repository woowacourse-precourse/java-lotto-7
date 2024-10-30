package lotto.validator;

public class PurchasePriceValidator {
    private static final String PRICE_MUST_BIGGER_THAN_ZERO = "로또 구입 금액은 0원보다 커야됩니다.";
    private static final String PRICE_MUST_1000_UNIT = "로또 구입 금액은 1000원 단위여야 합니다.";
    private static final int ZERO = 0;
    private static final int UNIT = 1000;

    public static void validatePurchasePrice(final int purchasePrice) {
        validateAvailableNum(purchasePrice);
        validatePriceUnit(purchasePrice);
    }

    private static void validateAvailableNum(final int purchasePrice) {
        if (purchasePrice <= ZERO) {
            throw new IllegalArgumentException(PRICE_MUST_BIGGER_THAN_ZERO);
        }
    }

    private static void validatePriceUnit(final int purchasePrice) {
        if (purchasePrice % UNIT != ZERO) {
            throw new IllegalArgumentException(PRICE_MUST_1000_UNIT);
        }
    }
}
