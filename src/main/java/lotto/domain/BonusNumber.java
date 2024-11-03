package lotto.domain;

import static lotto.LottoValue.MAX_NUMBER;
import static lotto.LottoValue.MIN_NUMBER;

import java.util.Objects;

public class BonusNumber {

    private static final String OUT_OF_RANGE = "보너스 넘버는 " + MIN_NUMBER + " ~ " + MAX_NUMBER + "사이어야 합니다.";
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
            throw new IllegalArgumentException(OUT_OF_RANGE);
        }
    }
}