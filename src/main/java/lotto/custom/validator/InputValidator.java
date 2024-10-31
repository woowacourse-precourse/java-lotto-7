package lotto.custom.validator;

import lotto.custom.common.Exceptions;

public class InputValidator {
    private final Exceptions exceptions;

    public InputValidator() {
        exceptions = new Exceptions();
    }

    public void validatePurchaseAmountInput(String input) {
        exceptions.emptyInput(input);
        exceptions.invalidCharacters(input, "[0-9]+");
        exceptions.integerOverflow(input);
    }
}