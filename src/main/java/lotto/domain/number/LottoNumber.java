package lotto.domain.number;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
    private static final int MINIMUM_NUMBER = 1;
    private static final int MAXIMUM_NUMBER = 45;
    private static final String ERROR_OUT_OF_RANGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final LottoNumber[] CACHE = new LottoNumber[MAXIMUM_NUMBER + 1];

    static {
        for (int i = MINIMUM_NUMBER; i <= MAXIMUM_NUMBER; i++) {
            CACHE[i] = new LottoNumber(i);
        }
    }

    private final int value;

    private LottoNumber(int value) {
        this.value = value;
    }

    public static LottoNumber from(int number) {
        validateNumber(number);
        return CACHE[number];
    }

    private static void validateNumber(int number) {
        if (number < MINIMUM_NUMBER || number > MAXIMUM_NUMBER) {
            throw new IllegalArgumentException(ERROR_OUT_OF_RANGE);
        }
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public int compareTo(LottoNumber other) {
        return Integer.compare(this.value, other.value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}