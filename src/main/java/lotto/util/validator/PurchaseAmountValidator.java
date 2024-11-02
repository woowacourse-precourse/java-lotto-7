package lotto.util.validator;

import static lotto.message.ErrorMessage.NOT_POSITIVE_INTEGER_INPUT_ERROR_MESSAGE;


public class PurchaseAmountValidator {

    public static void validate(int purchaseAmount) {
        validatePositiveNumber(purchaseAmount);
    }

    private static void validatePositiveNumber(int purchaseAmount) {
        if (purchaseAmount <= 0) {
            throw new IllegalArgumentException(NOT_POSITIVE_INTEGER_INPUT_ERROR_MESSAGE.getContent());
        }
    }
}
