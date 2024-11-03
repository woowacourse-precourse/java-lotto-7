package lotto.entity;

import static lotto.constant.Policy.LOTTO_NUMBER_MAX;
import static lotto.constant.Policy.LOTTO_NUMBER_MIN;

import lotto.constant.ExceptionMessage;

public record BonusNumber(
        Integer number
) {

    public BonusNumber {
        validateInRange(number);
    }

    private void validateInRange(Integer number) {
        if (number < LOTTO_NUMBER_MIN || number > LOTTO_NUMBER_MAX) {
            throw new IllegalArgumentException(ExceptionMessage.LOTTO_NUMBER_INVALID_RANGE);
        }
    }
}
