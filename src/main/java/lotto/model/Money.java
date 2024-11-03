package lotto.model;

import java.util.regex.Pattern;
import lotto.model.exception.DomainExceptionMessage;

public class Money {
    private static final Pattern numberPattern = Pattern.compile("^[0-9]+$");
    private final int value;

    public Money(final String value) {
        validateNumberPattern(value);
        this.value = Integer.parseInt(value);
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

    private void validateNumberPattern(final String money) {
        if (!numberPattern.matcher(money).matches()) {
            throw new IllegalArgumentException(
                    DomainExceptionMessage.INVALID_MONEY_FORMAT.getMessage()
            );
        }
    }
}
