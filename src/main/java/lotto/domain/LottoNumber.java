package lotto.domain;

import java.util.Objects;
import lotto.domain.exception.InvalidLottoNumberException;

class LottoNumber {
    private static final int MIN = 1;
    private static final int MAX = 45;
    private final int number;

    LottoNumber(int number) {
        validate(number);
        this.number = number;
    }

    int getNumber() {
        return number;
    }

    private void validate(int number) {
        if (number < MIN || number > MAX) {
            String message = String.format("숫자는 %d ~ %d 사이만 올 수 있습니다.", MIN, MAX);
            throw new InvalidLottoNumberException(message);
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
        LottoNumber lottoNumber1 = (LottoNumber) o;
        return number == lottoNumber1.number;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(number);
    }
}
