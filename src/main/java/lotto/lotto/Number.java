package lotto.lotto;

import lotto.exception.CustomException;
import lotto.exception.ExceptionMessage;

public class Number {

    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    private final int value;

    public Number(int value) {
        validateInRange(value);
        this.value = value;
    }

    private void validateInRange(int value) {
        if (value < MIN_LOTTO_NUMBER || value > MAX_LOTTO_NUMBER) {
            throw new CustomException(ExceptionMessage.INVALID_LOTTO_NUMBER_EXCEPTION);
        }
    }
}
