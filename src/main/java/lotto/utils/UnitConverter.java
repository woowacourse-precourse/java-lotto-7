package lotto.utils;

import static lotto.constants.Constants.PROFIT_FORMAT;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class UnitConverter {
    private static final NumberFormat numberFormatter = NumberFormat.getInstance();
    private static final NumberFormat decimalFormatter = new DecimalFormat(PROFIT_FORMAT);

    private UnitConverter() {

    }

    public static String convertUnit(int money) {
        return numberFormatter.format(money);
    }

    public static String convertUnit(BigDecimal profit) {
        return decimalFormatter.format(profit);
    }
}
