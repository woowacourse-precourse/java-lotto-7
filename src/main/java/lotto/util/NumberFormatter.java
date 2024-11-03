package lotto.util;

import java.text.DecimalFormat;

// 이름 변경해야 할 듯
public class NumberFormatter{

    public String formatNumber(int number) {
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        return decimalFormat.format(number);
    }
}
