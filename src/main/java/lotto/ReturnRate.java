package lotto;

import java.text.DecimalFormat;

public class ReturnRate {

    public String calculate(Result result, Price price) {
        long totalPrize = result.calculateTotalPrize();
        double returnRate = ((double) totalPrize / price.getValue()) * 100;

        return printFormatted(returnRate);
    }

    private String printFormatted(double returnRate) {
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.0");
        return decimalFormat.format(returnRate) + "%";
    }
}
