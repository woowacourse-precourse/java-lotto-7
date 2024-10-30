package lotto.validator;

import static lotto.message.ErrorMessage.EMPTY_INPUT_ERROR_MESSAGE;
import static lotto.message.ErrorMessage.NOT_INTEGER_RANGE_INPUT_MESSAGE;
import static lotto.message.ErrorMessage.NOT_POSITIVE_INTEGER_INPUT_MESSAGE;

public class PurchaseAmountValidator {

    private PurchaseAmountValidator() {
    }

    public static void validate(String rawPurchaseAmount) {
        validateNotEmptyString(rawPurchaseAmount);
        validatePositiveNumberString(rawPurchaseAmount);
    }

    private static void validateNotEmptyString(String rawPurchaseAmount) {
        if (rawPurchaseAmount.isBlank()) {
            throw new IllegalArgumentException(EMPTY_INPUT_ERROR_MESSAGE.getContent());
        }
    }

    private static void validatePositiveNumberString(String rawPurchaseAmount) {

        int purchaseAmount = 0;

        try {
            purchaseAmount = Integer.parseInt(rawPurchaseAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_INTEGER_RANGE_INPUT_MESSAGE.getContent());
        }

        validatePositiveNumber(purchaseAmount);
    }

    private static void validatePositiveNumber(int purchaseAmount) {
        if (purchaseAmount <= 0) {
            throw new IllegalArgumentException(NOT_POSITIVE_INTEGER_INPUT_MESSAGE.getContent());
        }
    }
}
