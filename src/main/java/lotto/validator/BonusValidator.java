package lotto.validator;

import lotto.enums.ExceptionMessage;

public class BonusValidator implements Validator {

    @Override
    public void validate(String input) {
        validateNull(input);
        validateNumeric(input);
        validateNonZeroStart(input);
        int number = Integer.parseInt(input);
        validateRange(number);
    }

    private void validateRange(int number) {

        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(ExceptionMessage.OUT_OF_RANGE.getMessage());
        }
    }

}
