package lotto.model;

public class ReturnRate {

    private final WinningMoney winningMoney;
    private final Money money;
    private double returnRate;

    public ReturnRate(WinningMoney winningMoney, Money money) {
        this.winningMoney = winningMoney;
        this.money = money;
        calculate();
    }

    private void calculate() {
        returnRate = (double)winningMoney.getTotalReward() / money.getMoney() * 100;
    }

    public double getReturnRate() {
        return returnRate;
    }
}
