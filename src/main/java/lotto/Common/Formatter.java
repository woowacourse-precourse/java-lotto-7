package lotto.Common;

import java.text.DecimalFormat;

public class Formatter {
    private Formatter() {}
    public static String currencyFormatted(int num) {
        DecimalFormat formatter = new DecimalFormat("#,###");
        return formatter.format(num);
    }

    public static String profitFormatted(double rate) {
        DecimalFormat formatter = new DecimalFormat("#,##0.0");
//        return Double.parseDouble(formatter.format(rate));
        return formatter.format(rate);
    }

    public static boolean canParseInt(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
