package lotto.lotto.domain.winning.domain;

import lotto.buyer.domain.Money;

public class Benefit {
    private final double PERCENTAGE = 100.0;
    private final Money benefit;
    public Benefit(Money benefit) {
        this.benefit = benefit;
    }
    public double getRateOfReturn(Money money) {
        return (((double) benefit.getMoney() / money.getMoney()) * PERCENTAGE);
    }
}
