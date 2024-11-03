package lotto.domain;

import lotto.validator.MoneyValidator;

public class Money {
    private final int amount;

    public Money(int amount) {
        validate(amount);
        this.amount = amount;
    }
    private void validate(int amount) {
        MoneyValidator.validateUnit(amount);
        MoneyValidator.validateValue(amount);
    }
    public int getAmount() {
        return amount;
    }
}
