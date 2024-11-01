package lotto.validator;

public class PurchaseAmountValidator {

    private static final String PURCHASE_AMOUNT_IS_POSITIVE_NUMBER = "[ERROR] 로또 구입 금액은 양의 정수여야 합니다.";
    private static final String PURCHASE_AMOUNT_DIVIDED_BY_1000 = "[ERROR] 로또 구입 금액은 1000원으로 나누어 떨어져야 합니다.";

    private static final int LOTTO_PRICE = 1000;

    public static void validatePurchaseAmount(final String purchaseAmount) {
        validatePurchaseAmountIsPositiveNumber(purchaseAmount);
        validatePurchaseAmountDividedBy1000(purchaseAmount);
    }

    private static void validatePurchaseAmountIsPositiveNumber(final String purchaseAmount) {
        if (!purchaseAmount.matches("\\d+") || Long.parseLong(purchaseAmount) <= 0) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_IS_POSITIVE_NUMBER);
        }
    }

    private static void validatePurchaseAmountDividedBy1000(final String purchaseAmount) {
        if (Long.parseLong(purchaseAmount) % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_DIVIDED_BY_1000);
        }
    }
}
