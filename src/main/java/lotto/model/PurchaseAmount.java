package lotto.model;

import lotto.validator.PurchaseAmountValidator;
import lotto.validator.Validator;

public class PurchaseAmount {
    private final long money;

    private PurchaseAmount(long money) {
        this.money = money;
    }

    public static PurchaseAmount of(long money) {
        Validator validator = new PurchaseAmountValidator(money);
        validator.validate();
        return new PurchaseAmount(money);
    }

    public int getAmount() {
        return (int) money / 1000;
    }

    public long getBudget() {
        return money;
    }
}
