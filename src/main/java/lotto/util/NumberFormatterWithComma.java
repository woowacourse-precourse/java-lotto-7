package lotto.util;

import java.text.DecimalFormat;

public class NumberFormatterWithComma implements NumberFormatter {

    @Override
    public String formatNumber(double number) {
        //int로 변환해야 하나
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        return decimalFormat.format(number);
    }
}
