package lotto.domain.model;

import java.util.Objects;
import lotto.exception.LottoNumberException;

public class LottoNumber {

    private static final int MINIMUM = 1;
    private static final int MAXIMUM = 45;

    private final int number;

    public LottoNumber(int number) {
        validateRange(number);
        this.number = number;
    }

    private void validateRange(int number) {
        if (number < MINIMUM || number > MAXIMUM) {
            throw new LottoNumberException(MINIMUM, MAXIMUM);
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
        return Objects.equals(number, lottoNumber.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    public int getNumber() {
        return number;
    }
}
