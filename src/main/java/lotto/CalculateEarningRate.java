package lotto;

public class CalculateEarningRate {
    public double calculate(int totalEarnings, int amountSpent) {
        return Math.round(((double) totalEarnings / amountSpent) * 10000) / 100.0;
    }
    public void printEarningRate(double earningRate){
        System.out.printf("총 수익률은 %.2f%%입니다.%n", earningRate);
    }
}