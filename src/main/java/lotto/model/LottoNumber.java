package lotto.model;

import static lotto.common.constant.LottoIntegerConstant.LOTTO_NUMBER_LOWER_BOUND;
import static lotto.common.constant.LottoIntegerConstant.LOTTO_NUMBER_UPPER_BOUND;
import static lotto.common.exception.ErrorMessage.LOTTO_NUMBER_OUT_OF_RANGE_ERROR;

public class LottoNumber {

    private final int number;

    private LottoNumber(int number) {
        validate(number);
        this.number = number;
    }

    public static LottoNumber from(int number) {
        return new LottoNumber(number);
    }

    public int number() {
        return number;
    }

    private void validate(int number) {
        if (number < LOTTO_NUMBER_LOWER_BOUND.number() || number > LOTTO_NUMBER_UPPER_BOUND.number()) {
            throw new IllegalArgumentException(LOTTO_NUMBER_OUT_OF_RANGE_ERROR.message());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoNumber lottoNumber = (LottoNumber) o;
        return number == lottoNumber.number;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(number);
    }
}
