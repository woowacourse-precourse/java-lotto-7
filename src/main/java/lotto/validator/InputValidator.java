package lotto.validator;

import static lotto.constants.LottoConstants.LOTTO_PRICE;
import static lotto.constants.LottoConstants.MAX_PURCHASE_AMOUNT;

import lotto.view.ErrorMessage;

public class InputValidator {

    public static void validateNotEmpty(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_INPUT_INVALID.getMessage());
        }
    }

    public static void validatePurchaseAmount(int amount) {
        validateAmountFormat(amount);
        validateAmountWithinLimit(amount);
    }

    private static void validateAmountFormat(int amount) {
        if (amount <= 0 || amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_AMOUNT_INVALID.getMessage());
        }
    }

    private static void validateAmountWithinLimit(int amount) {
        if (amount > MAX_PURCHASE_AMOUNT) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_AMOUNT_TOO_LARGE.getMessage());
        }
    }

}
