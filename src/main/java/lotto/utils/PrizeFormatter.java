package lotto.utils;

import java.text.NumberFormat;
import java.util.Locale;

public class PrizeFormatter {

    private PrizeFormatter() {
    }

    public static String formatPrize(int prize) {
        return NumberFormat.getNumberInstance(Locale.US).format(prize) + "원";
    }
}
