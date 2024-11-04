package lotto.announcer;

import lotto.lotto.Money;

public class Calculator {

    private final Money spentMoney;

    public Calculator(Money spentMoney) {
        this.spentMoney = spentMoney;
    }


    public double measureProfits(Money spentMoney, Money earnedMoney) {
        double profits = earnedMoney.getRateBy(spentMoney);
    }
}
