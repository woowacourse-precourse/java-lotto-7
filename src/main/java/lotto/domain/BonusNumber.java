package lotto.domain;

import java.util.Objects;

public class BonusNumber {

    private static final int MIN_NUM = 1;
    private static final int MAX_NUM = 45;
    private static final String OUT_OF_RANGE = "보너스 넘버는 " + MIN_NUM + " ~ " + MAX_NUM + "사이어야 합니다.";
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
        if (number < MIN_NUM || number > MAX_NUM) {
            throw new IllegalArgumentException(OUT_OF_RANGE);
        }
    }
}