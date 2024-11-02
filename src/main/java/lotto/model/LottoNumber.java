package lotto.model;

import java.util.Objects;
import lotto.util.NumberUtil;

public class LottoNumber {
    private final int value;

    public LottoNumber(int value) {
        this.value = value;
    }

    public static LottoNumber of(String value) {
        return new LottoNumber(NumberUtil.parseInt(value));
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
