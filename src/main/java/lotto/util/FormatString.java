package lotto.util;

public class FormatString {
    private FormatString() {
    }

    public static String formatPrize(int prize) {
        return String.format("%,d", prize);
    }

    public static String formatProfitRate(double profitRate) {
        return String.format("%.1f", profitRate);
    }
}
