package lotto.domain;

import java.util.List;
import java.util.Objects;
import lotto.domain.numberPicker.NumberPicker;
import lotto.domain.validator.ParamsValidator;
import lotto.exception.number.NumberCreationCountExceedException;
import lotto.exception.number.NumberOutOfRangeException;

final public class Number implements Comparable<Number> {

    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 45;

    private final int value;

    private Number(int value) {
        validateValueInRange(value);
        this.value = value;
    }

    private static void validateValueInRange(int value) {
        if (value < MIN_VALUE || MAX_VALUE < value) {
            throw new NumberOutOfRangeException(MIN_VALUE, MAX_VALUE);
        }
    }

    public static Number from(Integer number) {
        ParamsValidator.validateParamsNotNull(Number.class, number);

        return new Number(number);
    }

    public static List<Number> from(final List<Integer> numbers) {
        ParamsValidator.validateParamsNotNull(Number.class, numbers);

        return numbers.stream()
                .map(Number::new)
                .toList();
    }

    public static List<Number> createUniqueNumbers(Integer count, NumberPicker numberPicker) {
        ParamsValidator.validateParamsNotNull(Number.class, count, numberPicker);

        validateCreationCountWithinLimit(count);
        List<Integer> numbers = numberPicker.pickUniqueNumbersInRange(MIN_VALUE, MAX_VALUE, count);

        return from(numbers);
    }

    private static void validateCreationCountWithinLimit(Integer count) {
        int maxCreationCount = MAX_VALUE - MIN_VALUE + 1;
        if (count > maxCreationCount) {
            throw new NumberCreationCountExceedException(maxCreationCount);
        }
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Number number)) {
            return false;
        }
        return this.value == number.value;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    @Override
    public int compareTo(Number o) {
        return this.value - o.value;
    }
}
