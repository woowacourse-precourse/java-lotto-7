package lotto;

import java.text.DecimalFormat;

public class ReturnRate {
    private static final int PERCENTAGE_MULTIPLIER = 100;
    private static final String RETURN_RATE_FORMAT = "#,##0.0";
    private static final String RETURN_RATE_UNIT = "%";

    public String calculate(Result result, Payment payment) {
        long totalPrize = result.calculateTotalPrize();
        double returnRate = ((double) totalPrize / payment.get()) * PERCENTAGE_MULTIPLIER;
        return printFormatted(returnRate);
    }

    private String printFormatted(double returnRate) {
        DecimalFormat decimalFormat = new DecimalFormat(RETURN_RATE_FORMAT);
        return decimalFormat.format(returnRate) + RETURN_RATE_UNIT;
    }
}
