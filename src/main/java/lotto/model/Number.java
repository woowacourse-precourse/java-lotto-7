package lotto.model;

import lotto.exception.ExceptionMessage;
import lotto.exception.InputException;

import java.util.Objects;

public class Number {
    private final Integer value;
    public Number(Integer value) {
        this.value = Validator.validate(value);
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

    private static class Validator{
        static int validate(int value){
            if(value < 1 || value > 45){
                throw new InputException(ExceptionMessage.NUMBER_RANGE_ERROR);
            }
            return value;
        }
    }
}
