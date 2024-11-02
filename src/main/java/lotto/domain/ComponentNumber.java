package lotto.domain;

import lotto.constants.value.LottoRule;
import lotto.constants.string.RangeError;

import java.util.Objects;

import static lotto.constants.value.LottoRule.MAXIMUM_NUMBER_RANGE;

public class ComponentNumber implements Component {

    private final int number;

    public ComponentNumber(int lottoNumber) {
        validateRange(lottoNumber);
        this.number = lottoNumber;
    }

    private static void validateRange(int lottoNumber) {
        if (lottoNumber < LottoRule.MINIMUM_NUMBER_RANGE.getInstance() || lottoNumber > MAXIMUM_NUMBER_RANGE.getInstance()) {
            throw new IllegalArgumentException(RangeError.NUMBER.getInstance());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComponentNumber componentNumber1 = (ComponentNumber) o;
        return number == componentNumber1.number;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(number);
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
