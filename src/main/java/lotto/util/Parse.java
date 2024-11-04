package lotto.util;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;
import lotto.exception.LottoException.InvalidLottoPriceTypeException;

public class Parse {

    public static int stringToInt(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new InvalidLottoPriceTypeException();
        }
    }

    public static String formatWithCommas(BigDecimal number) {
        NumberFormat formatter = NumberFormat.getInstance(Locale.US);

        return formatter.format(number);
    }

}
