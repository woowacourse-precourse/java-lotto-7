package lotto.custom.validator;

import static lotto.custom.constants.NumberConstants.LOTTO_PRICE;

import lotto.custom.common.Exceptions;
import lotto.custom.constants.CustomErrorMessages;

public class InputValidator {
    private final Exceptions exceptions;

    public InputValidator() {
        exceptions = new Exceptions();
    }

    public void validatePurchaseAmountInput(String input) {
        exceptions.emptyInput(input);
        exceptions.invalidCharacters(input, "[0-9]+");
        exceptions.integerOverflow(input);
        validateAmountDivisibilityByLOTTOPRICE(input);
    }

    public void validateAmountDivisibilityByLOTTOPRICE(String input) {
        if (Integer.parseInt(input) % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(CustomErrorMessages.NOT_DIVISIBLE_BY_THOUSAND);
        }
    }
}