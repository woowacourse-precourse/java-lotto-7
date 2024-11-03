package lotto.domain.lotto;

import static lotto.constant.ExceptionMessage.INVALID_LOTTO_NUMBER;
import static lotto.constant.LottoConfig.LOTTO_NUMBER_END_INCLUSIVE;
import static lotto.constant.LottoConfig.LOTTO_NUMBER_START_INCLUSIVE;

import java.util.Objects;

public class Number {

    private final int number;

    public Number(int number) {
        validate(number);
        this.number = number;
    }

    private void validate(int number) {
        if (number < LOTTO_NUMBER_START_INCLUSIVE || number > LOTTO_NUMBER_END_INCLUSIVE) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER.getMessage());
        }
    }

    public int get() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Number number1 = (Number)o;
        return number == number1.number;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(number);
    }
}
