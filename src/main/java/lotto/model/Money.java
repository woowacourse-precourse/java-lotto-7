package lotto.model;

import lotto.policy.MoneyPolicy;

public class Money {
    private final MoneyPolicy moneyPolicy;
    private String money;

    public Money(String userInputMoney) {
        moneyPolicy = new MoneyPolicy();

        moneyPolicy.checkMoneyPolicy(userInputMoney);
        this.money = userInputMoney;
    }


    public String getMoney() {
        return money;
    }
}
