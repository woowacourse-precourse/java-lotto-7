package lotto.utils;

import java.text.NumberFormat;

public class UnitConverter {
    private static final NumberFormat nf = NumberFormat.getInstance();

    public static String convertUnit(int money) {
        return nf.format(money);
    }

    public static String convertUnit(double profit) {
        return nf.format(profit);
    }
}
