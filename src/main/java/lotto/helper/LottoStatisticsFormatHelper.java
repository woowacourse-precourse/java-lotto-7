package lotto.helper;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class LottoStatisticsFormatHelper {

    private final NumberFormat numberFormat;

    public LottoStatisticsFormatHelper() {
        this.numberFormat = NumberFormat.getNumberInstance();
    }

    public String formatPercentRateOfReturn(double percentRateOfReturn) {
        double roundedTwoDecimal = Math.round(percentRateOfReturn * 100.0) / 100.0;
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.0");
        return decimalFormat.format(roundedTwoDecimal);
    }
}
