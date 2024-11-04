package lotto.util;

import java.text.DecimalFormat;

public class NumberToString {
    static DecimalFormat integerFormatter = new DecimalFormat("###,###");
    static DecimalFormat decimalFormatter = new DecimalFormat("###,##0.0");

    public static String integerToString(int integer) {
        return integerFormatter.format(integer);
    }

    public static String decimalToString(double decimal) {
        return decimalFormatter.format(decimal);
    }
}
