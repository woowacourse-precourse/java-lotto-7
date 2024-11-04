package lotto.model;

import static lotto.common.LottoRule.LOTTO_END_NUMBER;
import static lotto.common.LottoRule.LOTTO_START_NUMBER;
import static lotto.validator.ValidationMessage.INVALID_NUMBER_RANGE;

import lotto.exception.InvalidInputException;

public record BonusNumber(int number) {
    public BonusNumber {
        validateNumberRange(number);
    }

    private void validateNumberRange(int number) {
        if (number < LOTTO_START_NUMBER.getValue() || number > LOTTO_END_NUMBER.getValue()) {
            throw new InvalidInputException(INVALID_NUMBER_RANGE.getMessage());
        }
    }
}
