package lotto.domain;

public class ROICalculator {
    public static double calculate(int totalSpent, int totalPrize) {
        if (totalSpent == 0) {
            return 0;
        }
        return Math.round((totalPrize / (double) totalSpent) * 1000) / 10.0;
    }
}
