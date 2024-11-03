package lotto.utils;

public class FormattingUtils {
    public static String formatCurrency(int amount) {
        return String.format("%,d", amount);
    }

    public static String formatRateOfReturnMessage(double rate) {
        String suffix = "입니다.";
        return String.format("%s", formatPercentage(rate)).concat(suffix);
    }

    private static String formatPercentage(double rate) {
        return String.format("%.1f%%", rate);
    }
}
