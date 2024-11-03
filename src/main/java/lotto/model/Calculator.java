package lotto.model;

public class Calculator {

    private static long paidMoney;
    private long winnings;

    public Calculator(int paidMoney) {
        this.paidMoney = paidMoney;
        this.winnings = WinningRank.calculateTotalWinnings();
    }

    public double calculateEarningRate() {
        if (paidMoney == 0) {
            throw new IllegalArgumentException();
        }
        return (double) (winnings - paidMoney) / paidMoney * 100;
    }

}
