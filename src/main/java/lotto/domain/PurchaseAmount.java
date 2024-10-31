package lotto.domain;

import lotto.domain.validator.PurchaseAmountValidator;

public class PurchaseAmount {

    private static final int THOUSAND_WON = 1000;

    private final int money;

    public PurchaseAmount(String invalidMoney) {
        PurchaseAmountValidator.validate(invalidMoney);
        this.money = Integer.parseInt(invalidMoney);
    }

    public int getPurchaseAmount() {
        return money / THOUSAND_WON;
    }

    public int getMoney() {
        return money;
    }
}
