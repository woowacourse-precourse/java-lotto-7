package lotto.util.validator;

import lotto.exception.InputError;
import lotto.exception.InputException;

public final class InputValidator {

    private static final String AVAILABLE_NUMBER_PATTERN = "^[0-9]+$";
    private static final String AVAILABLE_MONEY_PATTERN = "^[0-9]+$";

    private InputValidator() {
    }

    public static void validateLottoNumberInput(String numberInput) {
        validateNullOrEmpty(numberInput);
        if (!numberInput.trim().matches(AVAILABLE_NUMBER_PATTERN)) {
            throw new InputException(InputError.INVALID_FORMAT);
        }
    }
    public static void validateMoneyInput(String moneyInput) {
        validateNullOrEmpty(moneyInput);
        if (!moneyInput.trim().matches(AVAILABLE_MONEY_PATTERN)) {
            throw new InputException(InputError.INVALID_FORMAT);
        }
    }

    private static void validateNullOrEmpty(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new InputException(InputError.NOT_ALLOW_EMPTY);
        }
    }
}
