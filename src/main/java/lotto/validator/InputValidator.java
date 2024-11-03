package lotto.validator;


import static lotto.constants.LottoConstants.LOTTO_PRICE;

import lotto.view.ErrorMessage;

public class InputValidator {

    public static void validateNotEmpty(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_INPUT_INVALID.getMessage());
        }
    }

    public static void validatePurchaseAmount(int amount) {
        if (amount <= 0 || amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_AMOUNT_INVALID.getMessage());
        }
    }

}
