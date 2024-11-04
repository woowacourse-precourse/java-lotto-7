package lotto.domain;

public class ProfitCalculator {

    private ProfitCalculator() {
    }

    public static double calculateProfitRate(int prize, int money) {
        return ((double) prize / money) * 100;
    }
}
