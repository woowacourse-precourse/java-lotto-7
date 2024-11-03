package lotto.domain.util;

public class LottoStatistics {

    private static final int MAKE_PERCENTAGE = 100;
    private static final double ROUNDING_NUMBER = 100.0;

    public static double calculateReturnRate(double sumPrice, int money) {
        double returnRate = sumPrice / money * MAKE_PERCENTAGE;
        return Math.round(returnRate * MAKE_PERCENTAGE) / ROUNDING_NUMBER;
    }
}
