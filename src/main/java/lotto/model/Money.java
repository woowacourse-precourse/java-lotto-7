package lotto.model;

import lotto.policy.MoneyPolicy;

public class Money {
    private String money;

    public Money(String userInputMoney) {
        new MoneyPolicy().checkMoneyPolicy(userInputMoney);
        this.money = userInputMoney;
    }


    public String getMoney() {
        return money;
    }
}
