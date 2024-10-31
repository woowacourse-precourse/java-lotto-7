package lotto.validator;

import lotto.enums.ExceptionMessage;

import java.util.regex.Pattern;

public class AmountValidator {
    public void validate(String input) {
        validateNull(input);
        validateNumeric(input);
        validateNonZeroStart(input);
        validateUnit(input);
    }

    private void validateNull(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_BLANK.getMessage());
        }
    }

    private void validateUnit(String input) {
        int price = Integer.parseInt(input);
        if (price % 1000 != 0) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_MONEY_UNIT.getMessage());
        }
    }
}
