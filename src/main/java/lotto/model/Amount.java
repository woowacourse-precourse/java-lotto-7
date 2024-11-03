package lotto.model;

import lotto.validate.Validator;

public class Amount {
    private final int amount;

    public Amount(Integer amount) {
        Validator.validateAmount(amount);
        this.amount = amount;
    }
    public int getAmount() {
        return amount;
    }

    public int toCount(){
        return amount / 1000;
    }
}
