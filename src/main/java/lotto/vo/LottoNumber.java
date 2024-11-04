package lotto.vo;

import static lotto.constant.ExceptionMessage.NUMBER_OUT_OF_RANGE;
import static lotto.constant.LottoConstants.MAXIMUM_LOTTO_NUMBER;
import static lotto.constant.LottoConstants.MINIMUM_LOTTO_NUMBER;

import java.util.Objects;

public class LottoNumber {
    private final int value;

    private LottoNumber(int value) {
        validateInRange(value);

        this.value = value;
    }

    public static LottoNumber from(int number) {
        return new LottoNumber(number);
    }

    private void validateInRange(int value) {
        if (value < MINIMUM_LOTTO_NUMBER || value > MAXIMUM_LOTTO_NUMBER) {
            throw new IllegalArgumentException(NUMBER_OUT_OF_RANGE.format(MINIMUM_LOTTO_NUMBER, MAXIMUM_LOTTO_NUMBER));
        }
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LottoNumber that)) {
            return false;
        }
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
