package lotto.domain.number;

import java.util.Objects;

public class LottoNumber {
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 45;
    private static final String ERROR_RANGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final LottoNumber[] CACHE = new LottoNumber[MAX_VALUE + 1];

    static {
        for (int i = MIN_VALUE; i <= MAX_VALUE; i++) {
            CACHE[i] = new LottoNumber(i);
        }
    }

    private final int value;

    private LottoNumber(int value) {
        this.value = value;
    }

    public static LottoNumber of(int value) {
        validateRange(value);
        return CACHE[value];
    }

    private static void validateRange(int value) {
        if (value < MIN_VALUE || value > MAX_VALUE) {
            throw new IllegalArgumentException(ERROR_RANGE);
        }
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoNumber that = (LottoNumber) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}