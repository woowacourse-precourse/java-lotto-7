package lotto.domain;

import lotto.constants.value.LottoRule;
import lotto.constants.message.RangeError;

import java.util.Objects;

import static lotto.constants.value.LottoRule.MAXIMUM_NUMBER_RANGE;

public class lottoNumber implements Component {

    private final int number;

    public lottoNumber(int lottoNumber) {
        validateRange(lottoNumber);
        this.number = lottoNumber;
    }

    private static void validateRange(int lottoNumber) {
        if (lottoNumber < LottoRule.MINIMUM_NUMBER_RANGE.getValue() || lottoNumber > MAXIMUM_NUMBER_RANGE.getValue()) {
            System.out.println(RangeError.NUMBER.getMessage());
            throw new IllegalArgumentException(RangeError.NUMBER.getMessage());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        lottoNumber lottoNumber1 = (lottoNumber) o;
        return number == lottoNumber1.number;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(number);
    }
}
