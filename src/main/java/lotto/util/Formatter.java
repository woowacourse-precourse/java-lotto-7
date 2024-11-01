package lotto.util;

import java.text.DecimalFormat;

public class Formatter {

    private Formatter() {
    }

    public static String formatToCurrency(Integer amount) {
        return new DecimalFormat("###,###").format(amount);
    }
}
