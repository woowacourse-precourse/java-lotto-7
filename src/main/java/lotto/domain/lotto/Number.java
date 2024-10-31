package lotto.domain.lotto;

import lotto.domain.constants.value.LottoRule;
import lotto.domain.constants.message.RangeError;

import java.util.Objects;

import static lotto.domain.constants.value.LottoRule.MAXIMUM_NUMBER_RANGE;

public class Number {

    private final int number;

    public Number(int lottoNumber) {
        validateRange(lottoNumber);
        this.number = lottoNumber;
    }

    private static void validateRange(int lottoNumber) {
        if (lottoNumber < LottoRule.MINIMUM_NUMBER_RANGE.getValue() || lottoNumber > MAXIMUM_NUMBER_RANGE.getValue()) {
            System.out.println(RangeError.NUMBER.getMessage());
            throw new IllegalArgumentException(RangeError.NUMBER.getMessage());
        }
    }

    public int getLottoNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number number1 = (Number) o;
        return number == number1.number;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(number);
    }
}
