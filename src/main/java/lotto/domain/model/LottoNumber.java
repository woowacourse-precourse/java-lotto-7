package lotto.domain.model;

import static java.lang.String.format;
import static lotto.domain.constant.LottoConstraintProperties.MAXIMUM_NUMBER_VALUE;
import static lotto.domain.constant.LottoConstraintProperties.MINIMUM_NUMBER_VALUE;

public class LottoNumber {
    private static final String VIOLATION_LOTTO_NUMBER_VALUE = "[ERROR] 로또 번호 [%d - %d] 까지의 숫자로만 이루어져야 합니다.";

    private final int number;

    public LottoNumber(int number) {
        validate(number);
        this.number = number;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LottoNumber that)) {
            return false;
        }

        return number == that.number;
    }

    @Override
    public int hashCode() {
        return number;
    }

    @Override
    public String toString() {
        return String.valueOf(this.number);
    }

    private void validate(int number) {
        if (number < MINIMUM_NUMBER_VALUE || number > MAXIMUM_NUMBER_VALUE) {
            throw new IllegalArgumentException(
                    format(VIOLATION_LOTTO_NUMBER_VALUE, MINIMUM_NUMBER_VALUE, MAXIMUM_NUMBER_VALUE)
            );
        }
    }
}
