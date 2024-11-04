package lotto.business;

public record Money(int value) {
    private static final int MIN_VALUE = 0;
    private static final int UNIT = 1_000;

    public Money {
        validate(value);
    }

    public boolean isDivisibleBy(Money divisor) {
        return value % divisor.value == 0;
    }

    public int multiply(int multiplier) {
        return value * multiplier;
    }

    public int divide(Money divisor) {
        return value / divisor.value;
    }

    private void validate(int value) {
        if (!isInRange(value)) {
            throw BusinessException.NEGATIVE_MONEY.getException();
        }

        if (!isMultipleOfUnit(value)) {
            throw BusinessException.INVALID_MONEY_UNIT.getException();
        }
    }

    private boolean isInRange(int value) {
        return value >= MIN_VALUE;
    }

    private boolean isMultipleOfUnit(int value) {
        return value % UNIT == 0;
    }
}
