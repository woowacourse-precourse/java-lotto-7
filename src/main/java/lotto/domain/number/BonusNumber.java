package lotto.domain.number;

import static lotto.LottoValue.MAX_NUMBER;
import static lotto.LottoValue.MIN_NUMBER;

import java.util.Objects;
import lotto.domain.LottoErrorTemplate;

public class BonusNumber {

    private final int number;

    public BonusNumber(int number) {
        validateOutOfRange(number);
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BonusNumber that)) {
            return false;
        }
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(number);
    }

    public int getNumber() {
        return number;
    }

    private void validateOutOfRange(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException(LottoErrorTemplate.NUMBER_OUT_OF_RANGE.format(MIN_NUMBER, MAX_NUMBER));
        }
    }
}