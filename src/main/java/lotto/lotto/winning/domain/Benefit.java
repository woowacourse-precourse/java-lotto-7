package lotto.lotto.winning.domain;

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
    @Override
    public String toString() {
        return String.valueOf(benefit.getMoney());
    }
}
