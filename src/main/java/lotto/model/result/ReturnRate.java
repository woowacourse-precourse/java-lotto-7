package lotto.model.result;

import java.text.DecimalFormat;
import lotto.model.payment.Payment;

public class ReturnRate {
    private static final int PERCENTAGE_MULTIPLIER = 100;
    private static final String RETURN_RATE_FORMAT = "#,##0.0";
    private static final String RETURN_RATE_UNIT = "%";

    private final double value;

    private ReturnRate(double value) {
        this.value = value;
    }

    public static ReturnRate from(Result result, Payment payment) {
        long totalPrize = result.calculateTotalPrize();
        double returnRate = ((double) totalPrize / payment.get()) * PERCENTAGE_MULTIPLIER;
        return new ReturnRate(returnRate);
    }

    public String getFormatted() {
        DecimalFormat decimalFormat = new DecimalFormat(RETURN_RATE_FORMAT);
        return decimalFormat.format(this.value) + RETURN_RATE_UNIT;
    }
}
