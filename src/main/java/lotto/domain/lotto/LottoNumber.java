package lotto.domain.lotto;

import static lotto.common.exception.ErrorMessage.LOTTO_NUMBER_OUT_OF_RANGE;

import java.util.Objects;
import lotto.common.exception.LottoException;

public class LottoNumber {

    private final Integer number;

    public LottoNumber(Integer number) {
        validate(number);
        this.number = number;
    }

    private void validate(Integer number) {
        if (number < 1 || number > 45) {
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
