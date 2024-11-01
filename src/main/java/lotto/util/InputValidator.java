package lotto.util;

public class InputValidator {

    private static final String PURCHASE_AMOUNT_SUFFIX = " (금액: ";
    private static final String PURCHASE_AMOUNT_SUFFIX_END = ")";

    public void validatePurchaseAmount(int purchaseAmount, int lottoPrice) {
        if (purchaseAmount % lottoPrice != 0) {
            throw new IllegalArgumentException(
                    ErrorMessage.PURCHASE_AMOUNT_NOT_DIVISION_ERROR.getMessage()
                            + PURCHASE_AMOUNT_SUFFIX + purchaseAmount
                            + PURCHASE_AMOUNT_SUFFIX_END);
        }
    }

}
