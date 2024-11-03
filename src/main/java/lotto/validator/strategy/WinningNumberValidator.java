package lotto.validator.strategy;

import lotto.exception.custom.InvalidWinningNumberFormatException;
import lotto.validator.InputValidator;

public class WinningNumberValidator implements InputValidator {

    private static final String WINNING_NUMBER_PATTERN = "^(?:([1-9]|[1-3][0-9]|4[0-5])(,(?!$)|$))+$";

    @Override
    public void validate(String input) {
        if (isWinningNumberFormatInvalid(input)) {
            throw new InvalidWinningNumberFormatException();
        }
    }

    private boolean isWinningNumberFormatInvalid(String inputWinningNumber) {
        return !inputWinningNumber.matches(WINNING_NUMBER_PATTERN);
    }
}
