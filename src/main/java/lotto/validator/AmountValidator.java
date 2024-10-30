package lotto.validator;

import lotto.enums.Exceptions;

public class AmountValidator {
    public void validate(String input) {
        validateNull(input);
        validateUnit(input);
    }

    private void validateNull(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(Exceptions.NOT_BLANK.getMessage());
        }
    }

    private void validateUnit(String input) {
        int price = Integer.parseInt(input);
        if (price % 1000 != 0) {
            throw new IllegalArgumentException(Exceptions.INVALID_MONEY_UNIT.getMessage());
        }
    }
}
