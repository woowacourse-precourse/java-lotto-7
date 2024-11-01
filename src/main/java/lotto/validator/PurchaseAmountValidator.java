package lotto.validator;

import static lotto.constants.LottoConstants.*;

public class PurchaseAmountValidator {
    public PurchaseAmountValidator(String input) {
        validateNoSpace(input);
        validateIsNumber(input);
    }

    private void validateIsNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.MUST_BE_NUMBER.getMessage(PURCHASE_AMOUNT));
        }
    }

    private void validateNoSpace(String input) {
        if (!input.equals(input.strip())) {
            throw new IllegalArgumentException(ErrorMessage.MUST_BE_NO_SPACE.getMessage(PURCHASE_AMOUNT));
        }
    }
}
