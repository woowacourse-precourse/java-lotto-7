package lotto.model;

import java.util.Objects;

import static lotto.exception.ErrorMessages.*;
import static lotto.util.Validator.isInteger;
import static lotto.util.Validator.isPositive;

public class Cost {
    private final int value;

    public Cost(String value) {
        validate(value);
        this.value = Integer.parseInt(value);
    }

    public int getValue() {
        return value;
    }

    private void validate(String value) {
        if (!isInteger(value) || !isPositive(value)) {
            throw new IllegalArgumentException(COST_POSITIVE_INTEGER_ERROR);
        }

        if (!isDividedThousand(value)) {
            throw new IllegalArgumentException(DIVISIBLE_BY_THOUSAND_COST_ERROR);
        }
    }

    public boolean isDividedThousand(String value) {
        int castedValue = Integer.parseInt(value);
        return castedValue % 1000 == 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cost cost = (Cost) o;
        return value == cost.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
