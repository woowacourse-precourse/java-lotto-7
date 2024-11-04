package lotto.service;

public class RateOfReturnCalculator {

    private static final String IS_AMOUNT_ZERO_EXCEPTION_MESSAGE = "[ERROR] 구입금액이 올바른 값이 아닙니다.";
    private static final double PERCENTAGE_CONVERSION_FACTOR = 100.0;
    private static final double ROUNDING_FACTOR = 10.0;

    public static double calculateRateOfReturn(int amount, int finalPrize) {
        if (amount == 0) {
            throw new ArithmeticException(IS_AMOUNT_ZERO_EXCEPTION_MESSAGE);
        }

        double rateOfReturn = (double) finalPrize / amount * PERCENTAGE_CONVERSION_FACTOR;
        return Math.round(rateOfReturn * ROUNDING_FACTOR) / ROUNDING_FACTOR;
    }
}
