package lotto.util;

public class Calculator {

    private Calculator() {
    }

    public static double calculateProfitRate(int cost, int revenue) {
        return (double) revenue / cost * 100;
    }
}
