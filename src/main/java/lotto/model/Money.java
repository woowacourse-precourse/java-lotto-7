package lotto.model;

public class Money {
    private static final double TO_PERCENTAGE = 100.0;

    protected final int money;

    public Money(final int money) {
        this.money = money;
    }

    public double getEarningRate(Money earned) {
        return TO_PERCENTAGE * earned.money / this.money;
    }
}
