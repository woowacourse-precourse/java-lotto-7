package lotto.model;

public class EarningCalculator {
    private final static long[] price = {5000, 50000, 1500000, 30000000, 2000000000};

    public double calculate(int[] winning, int purchase) {
        long total = 0;
        for (int i = 0; i < 5; i++) {
            total += (price[i] * winning[i]);
        }
        return total / (double) purchase * 100;
    }
}
