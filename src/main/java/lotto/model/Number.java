package lotto.model;

import java.util.Objects;

import static lotto.validate.Validator.validateNumber;

public class Number {
    private final Integer value;
    public Number(Integer value) {
        validateNumber(value);
        this.value = value;
    }

    public int get() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number number = (Number) o;
        return Objects.equals(value, number.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

}
