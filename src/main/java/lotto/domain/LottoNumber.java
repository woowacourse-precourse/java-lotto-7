package lotto.domain;

import static lotto.constants.LottoConstants.MAX_LOTTO_NUMBER;
import static lotto.constants.LottoConstants.MIN_LOTTO_NUMBER;
import static lotto.exception.constants.ErrorMessage.INVALID_NUMBER;
import static lotto.exception.constants.ErrorMessage.LOTTO_NUMBER_OUT_OF_RANGE;

import lotto.exception.LottoException;

public class LottoNumber {

    private final Integer number;

    public LottoNumber(final Integer number) {
        validateNull(number);
        validateNumber(number);

        this.number = number;
    }

    private void validateNull(final Integer number) {
        if (number == null) {
            throw new LottoException(INVALID_NUMBER.getMessage());
        }
    }

    private void validateNumber(final Integer number) {
        if (number < MIN_LOTTO_NUMBER.getValue() || number > MAX_LOTTO_NUMBER.getValue()) {
            throw new LottoException(LOTTO_NUMBER_OUT_OF_RANGE.getMessage());
        }
    }

    public Integer getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "LottoNumber{" +
                "number=" + number +
                '}';
    }
}
