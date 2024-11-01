package lotto;

import java.util.Objects;

public final class LottoNumber {

    public static final int MIN_VALUE = 1;
    public static final int MAX_VALUE = 45;
    public static final String OUT_OF_RANGE_ERROR_MESSAGE = "로또 번호는 최소 1부터 45까지의 숫자여야 합니다.";

    private final int value;

    public LottoNumber(int value) {
        validate(value);
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    private void validate(int value) {
        if (value < MIN_VALUE || value > MAX_VALUE) {
            throw new IllegalArgumentException(OUT_OF_RANGE_ERROR_MESSAGE);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LottoNumber number)) {
            return false;
        }
        return value == number.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
