package lotto.domain;

import lotto.common.validator.NumberValidator;

import java.util.Objects;

public class Number {
    private final int number;

    public Number(String number) {
        NumberValidator.validate(number);
        this.number = Integer.parseInt(number);
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number compare = (Number) o;
        return number == compare.getNumber();
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
