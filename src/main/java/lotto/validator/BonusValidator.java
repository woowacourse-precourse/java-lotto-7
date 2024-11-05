package lotto.validator;

import lotto.enums.ExceptionMessage;
import lotto.enums.LottoValue;

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
        int min = LottoValue.MIN_RANGE_NUMBER.getValue();
        int max = LottoValue.MAX_RANGE_NUMBER.getValue();
        if (number < min || number > max) {
            throw new IllegalArgumentException(ExceptionMessage.OUT_OF_RANGE.getMessage());
        }
    }

}
