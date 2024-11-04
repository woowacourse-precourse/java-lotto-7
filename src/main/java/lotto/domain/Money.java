package lotto.domain;

import lotto.validator.MoneyValidator;

public class Money {
    private int value;

    public Money(String value) {
        validate(value);
        this.value = Integer.parseInt(value);
    }

    private void validate(String value) {
        MoneyValidator.isNumeric(value);
        MoneyValidator.isPositive(value);
        MoneyValidator.checkDivisibleByThousand(value);
    }

    public int getValue() {
        return value;
    }

}
