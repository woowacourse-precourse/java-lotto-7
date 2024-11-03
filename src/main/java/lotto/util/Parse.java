package lotto.util;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public class Parse {

    public static int stringToInt(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자로 변환할 수 없습니다.");
        }
    }

    public static String formatWithCommas(BigDecimal number) {
        NumberFormat formatter = NumberFormat.getInstance(Locale.US);

        return formatter.format(number);
    }

}
