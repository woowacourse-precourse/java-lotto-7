package lotto.domain;

import static lotto.exception.number.NumberErrorCode.INVALID_NUMBER_RANGE;

import lotto.exception.LottoException;

public class Number {

    private final Integer number;

    public Number(Integer number) {
        validate(number);
        this.number = number;
    }

    public Integer getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }

    private void validate(Integer number) {
        validateNumberRange(number);
    }

    private void validateNumberRange(Integer number) {
        if (number < 1 || number > 45) {
            throw new LottoException(INVALID_NUMBER_RANGE);
        }
    }
}
