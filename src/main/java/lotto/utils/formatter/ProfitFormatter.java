package lotto.utils.formatter;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public class ProfitFormatter {

    private static final String PERCENT_SYMBOL = "%";

    private ProfitFormatter() {
    }

    public static String formatProfitRate(BigDecimal profitRate) {
        NumberFormat numberFormat = NumberFormat.getInstance(Locale.KOREA);
        return numberFormat.format(profitRate) + PERCENT_SYMBOL;
    }
}
