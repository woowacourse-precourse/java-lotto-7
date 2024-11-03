package lotto;

import java.text.DecimalFormat;

public class ReturnRate {

    public String calculate(Result result, Payment payment) {
        long totalPrize = result.calculateTotalPrize();
        double returnRate = ((double) totalPrize / payment.getValue()) * 100;

        return printFormatted(returnRate);
    }

    private String printFormatted(double returnRate) {
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.0");
        return decimalFormat.format(returnRate) + "%";
    }
}
