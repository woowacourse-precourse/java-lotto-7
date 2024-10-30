package lotto;

import lotto.util.validator.MoneyValidator;

public class Money {

    private final long amount;

    public Money(final long amount) {
        MoneyValidator.validate(amount);
        this.amount = amount;
    }

    public long getAmount() {
        return amount;
    }
}
