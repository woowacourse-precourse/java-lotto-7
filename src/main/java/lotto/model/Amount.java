package lotto.model;

import lotto.validate.Validator;

public class Amount {
    private final int amount;

    public Amount(String amount) {
        Validator.validateAmount(amount);
        this.amount = Integer.parseInt(amount);
    }
    public int getAmount() {
        return amount;
    }

    public int toCount(){
        return amount / 1000;
    }
}
