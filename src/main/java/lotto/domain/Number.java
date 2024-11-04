package lotto.domain;

import static lotto.constant.lotto.LottoConstants.MAX_LOTTO_NUMBER;
import static lotto.constant.lotto.LottoConstants.MIN_LOTTO_NUMBER;
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
        if (number < MIN_LOTTO_NUMBER.getIntValue() || number > MAX_LOTTO_NUMBER.getIntValue()) {
            throw new LottoException(INVALID_NUMBER_RANGE);
        }
    }
}
