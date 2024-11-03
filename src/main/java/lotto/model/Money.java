package lotto.model;

import java.util.regex.Pattern;
import lotto.model.exception.DomainExceptionMessage;

public class Money {
    private static final Pattern numberPattern = Pattern.compile("^-?[0-9]+$");
    private static final int MONEY_UNIT_VALUE = 1000;
    private static final int LOWER_LIMIT = 0;

    private final long value;

    public Money(final String value) {
        validate(value);
        this.value = getParsedLong(value);
    }

    private Money(final long value) {
        this.value = value;
    }

    public Money add(long value) {
        return new Money(this.value + value);
    }

    public Money minus(int value) {
        long calculatedValue = this.value - value;
        if (calculatedValue < LOWER_LIMIT) {
            throw new IllegalStateException(
                    DomainExceptionMessage.INVALID_MONEY_VALUE.getMessage()
            );
        }
        return new Money(calculatedValue);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Money money)) {
            return false;
        }
        return this.value == money.value;
    }

    private void validate(final String money) {
        validateNumberPattern(money);
        validateMinus(money);
        validateMoneyUnit(money);
    }

    private void validateNumberPattern(final String money) {
        if (!numberPattern.matcher(money).matches()) {
            throw new IllegalArgumentException(
                    DomainExceptionMessage.INVALID_MONEY_FORMAT.getMessage()
            );
        }
    }

    private void validateMinus(final String money) {
        if (getParsedLong(money) < 0) {
            throw new IllegalArgumentException(
                    DomainExceptionMessage.INVALID_MONEY_VALUE.getMessage()
            );
        }
    }

    private void validateMoneyUnit(final String money) {
        if (getParsedLong(money) % MONEY_UNIT_VALUE != 0) {
            throw new IllegalArgumentException(
                    DomainExceptionMessage.INVALID_MONEY_UNIT.getMessage()
            );
        }
    }


    private long getParsedLong(String money) {
        return Long.parseLong(money);
    }
}
