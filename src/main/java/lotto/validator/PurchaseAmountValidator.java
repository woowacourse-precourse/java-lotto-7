package lotto.validator;

import lotto.exception.ErrorMessage;
import lotto.exception.LottoException;

public class PurchaseAmountValidator {
    private static final int MAX_AMOUNT = 100000;
    private static final String VALID_AMOUNT_PATTERN = "^[1-9]\\d*000$";

    private PurchaseAmountValidator() {
    }

    public static void validate(String purchaseAmount) {
        validateNotNull(purchaseAmount);
        validateNotEmpty(purchaseAmount);
        validatePurchaseAmountPattern(purchaseAmount);
        validateMaxPurchaseAmount(purchaseAmount);
    }

    private static void validateNotNull(String input) {
        if (input == null) {
            throw LottoException.from(ErrorMessage.NULL_INPUT_ERROR);
        }
    }

    private static void validateNotEmpty(String input) {
        if (input.isBlank()) {
            throw LottoException.from(ErrorMessage.EMPTY_INPUT_ERROR);
        }
    }

    private static void validatePurchaseAmountPattern(String purchaseAmount) {
        if (isPurchaseAmountPatternInvalid(purchaseAmount)) {
            throw LottoException.from(ErrorMessage.INVALID_AMOUNT_PATTERN_ERROR);
        }
    }

    private static void validateMaxPurchaseAmount(String purchaseAmount) {
        if (isMaxPurchaseAmountExceeded(purchaseAmount)) {
            throw LottoException.from(ErrorMessage.MAX_AMOUNT_ERROR);
        }
    }

    private static boolean isPurchaseAmountPatternInvalid(String purchaseAmount) {
        return !purchaseAmount.matches(VALID_AMOUNT_PATTERN);
    }

    private static boolean isMaxPurchaseAmountExceeded(String purchaseAmount) {
        return parsePurchaseAmountToInt(purchaseAmount) > MAX_AMOUNT;
    }

    private static int parsePurchaseAmountToInt(String amountStr) {
        return Integer.parseInt(amountStr);
    }
}
