package lotto.domain.lotto;

import static lotto.common.exception.ErrorMessage.LOTTO_NUMBER_OUT_OF_RANGE;

import java.util.Objects;
import lotto.common.exception.LottoException;

public class LottoNumber {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private final Integer number;

    public LottoNumber(Integer number) {
        validateOutOfRange(number);
        this.number = number;
    }

    private void validateOutOfRange(Integer number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new LottoException(LOTTO_NUMBER_OUT_OF_RANGE);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LottoNumber that)) {
            return false;
        }
        return Objects.equals(number, that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return number.toString();
    }
}
