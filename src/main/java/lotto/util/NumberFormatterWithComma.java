package lotto.util;

import java.text.DecimalFormat;

public class NumberFormatterWithComma implements NumberFormatter {

    @Override
    public String formatNumber(double number) {
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        return decimalFormat.format(number);
    }
}
