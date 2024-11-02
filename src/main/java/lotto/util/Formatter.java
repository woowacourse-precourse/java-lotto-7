package lotto.util;

import java.text.DecimalFormat;

public class Formatter {

    private Formatter() {
    }

    public static String formatToCurrency(Long amount) {
        return new DecimalFormat("###,###").format(amount);
    }

    public static String formatToErrorMessage(String message) {
        return String.format("[ERROR] %s", message);
    }
}
