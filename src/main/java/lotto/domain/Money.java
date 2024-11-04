package lotto.domain;

import lotto.util.Validator;

public class Money {
    private final int amount;

    public Money(int amount) {
        this.amount = Validator.parseAndValidateAmount(amount);
    }

    public int getAmount() {
        return amount;
    }
}