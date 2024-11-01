package lotto.lotto;

import java.util.Objects;
import lotto.exception.CustomException;
import lotto.exception.ExceptionMessage;

public class Number {

    private final int value;

    public Number(int value) {
        validateInRange(value);
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    private void validateInRange(int value) {
        if (value < LottoConstant.MIN_LOTTO_NUMBER.getValue() || value > LottoConstant.MAX_LOTTO_NUMBER.getValue()) {
            throw new CustomException(ExceptionMessage.INVALID_LOTTO_NUMBER_EXCEPTION);
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
        Number number = (Number) o;
        return value == number.value;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
