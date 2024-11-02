package lotto.domain;

import java.util.Objects;

public class Number {

    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 45;

    private int value;

    public Number(int value) {
        validate(value);

        this.value = value;
    }

    private void validate(int value) {
        if (value < MIN_VALUE || value > MAX_VALUE) {
            throw new IllegalArgumentException("숫자는 %d 이상 %d이하 이어야 합니다".formatted(MIN_VALUE, MAX_VALUE));
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
        Number number = (Number) o;
        return value == number.value;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
