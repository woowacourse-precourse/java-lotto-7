package lotto;

public class Calculator {

    private static double earningRate;
    private static long paidMoney;
    private long winnings;

    public Calculator() {
        this.earningRate = calculateEarningRate();
        this.paidMoney = paidMoney;
        this.winnings = WinningRank.calculateTotalWinnings();
    }

    private double calculateEarningRate() {
        return (double) (winnings - paidMoney) / paidMoney * 100;
    }

}
