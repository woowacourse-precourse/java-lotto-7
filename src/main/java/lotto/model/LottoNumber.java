package lotto.model;

import java.util.Objects;
import lotto.util.NumberUtil;

public class LottoNumber {
    private final int value;

    public LottoNumber(int value) {
        validateRange(value);
        this.value = value;
    }

    public static LottoNumber from(String value) {
        return new LottoNumber(NumberUtil.parseInt(value));
    }

    private void validateRange(int value) {
        if (value < 1 || 45 < value) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1에서 45사이의 숫자만 가능합니다.");
        }
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
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
