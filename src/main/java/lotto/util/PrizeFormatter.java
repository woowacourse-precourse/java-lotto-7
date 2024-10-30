package lotto.util;

import java.text.NumberFormat;

public class PrizeFormatter {
    public static String formatPrize(int prize) {
        NumberFormat formatter = NumberFormat.getNumberInstance();
        return formatter.format(prize);
    }
}
