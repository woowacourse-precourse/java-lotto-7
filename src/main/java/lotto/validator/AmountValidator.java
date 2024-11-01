package lotto.validator;

import lotto.enums.ExceptionMessage;

public class AmountValidator implements Validator {
    @Override
    public void validate(String input) {
        validateNull(input);
        validateNumeric(input);
        validateNonZeroStart(input);
        validateUnit(input);
    }

    private void validateUnit(String input) {
        int price = Integer.parseInt(input);
        if (price % 1000 != 0) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_MONEY_UNIT.getMessage());
        }
    }

}
