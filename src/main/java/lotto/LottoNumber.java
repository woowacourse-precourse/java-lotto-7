package lotto;

import java.util.Objects;

public class LottoNumber {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private final int number;

    public LottoNumber(int number) {
        if (inRange(number)) {
            throw new IllegalArgumentException("로또의 숫자는 1~45사이의 숫자이여야 합니다.");
        }
        this.number = number;
    }

    public LottoNumber(String value) {
        this(toInt(value));
    }

    private static int toInt(String value) {
        return Integer.parseInt(value);
    }

    private static boolean inRange(int number) {
        return number < MIN_NUMBER || MAX_NUMBER < number;
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
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
