package lotto.global.exception;

import java.util.function.Predicate;

public class ValidatorBuilder<T> {
    private final T value;
    private int numericValue;

    private ValidatorBuilder(final T value) {
        this.value = value;
    }

    public static <T> ValidatorBuilder<T> from(final T value) {
        return new ValidatorBuilder<>(value);
    }

    public ValidatorBuilder<T> validate(final Predicate<T> condition, final Exception exception) {
        if (condition.test(value)) {
            throw new IllegalArgumentException(exception.message);
        }
        return this;
    }

    public ValidatorBuilder<T> validateInteger(final Predicate<Integer> condition, final Exception exception) {
        if (condition.test(numericValue)) {
            throw new IllegalArgumentException(exception.message);
        }
        return this;
    }

    public ValidatorBuilder<T> validateIsInteger() {
        try {
            numericValue = Integer.parseInt((String) value);
            return this;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Exception.NOT_INTEGER.message);
        }
    }

    public T get() {
        return value;
    }

    public int getNumericValue() {
        return numericValue;
    }
}
