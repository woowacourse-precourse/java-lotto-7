package lotto.helper;

import java.text.DecimalFormat;

public class CurrencyFormatter {
    private static final DecimalFormat formatter = new DecimalFormat("###,###");
    public static String format(Integer amount) {
        return formatter.format(amount);
    }
}
