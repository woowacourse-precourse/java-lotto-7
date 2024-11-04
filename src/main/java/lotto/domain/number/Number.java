package lotto.domain.number;

import static lotto.resources.Constants.LOTTO_MAX_NUMBER;
import static lotto.resources.Constants.LOTTO_MIN_NUMBER;
import static lotto.resources.ErrorMessages.INVALID_RANGE_LOTTO_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Objects;

public class Number {
    private final int number;

    private Number(final int number) {
        validateNumber(number);
        this.number = number;
    }

    public static Number from(final int number) {
        return new Number(number);
    }

    public static Number generateRandomNumber() {
        int randomNumber = Randoms.pickNumberInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER);

        return from(randomNumber);
    }

    private void validateNumber(final int number) {
        if (number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException(INVALID_RANGE_LOTTO_NUMBER.getMessage());
        }
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final Number otherNumber = (Number) obj;
        return Objects.equals(number, otherNumber.number);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(number);
    }

    public int getNumber() {
        return number;
    }
}
