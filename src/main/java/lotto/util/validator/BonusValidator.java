package lotto.util.validator;

import static lotto.util.Constants.LOTTO_MAX_RANGE;
import static lotto.util.Constants.LOTTO_MIN_RANGE;

import lotto.util.ExceptionMessage;

public class BonusValidator extends AbstractValidator<Integer> {

    @Override
    protected Integer convertAndValidate(String input) {
        int bonusValue = Integer.parseInt(input);
        validateBonusNumberRange(bonusValue);
        return bonusValue;
    }

    private void validateBonusNumberRange(int number) {
        if (number < LOTTO_MIN_RANGE || number > LOTTO_MAX_RANGE) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_WINNING_NUMBER_LOTTO_RANGE.getMessage());
        }
    }
}