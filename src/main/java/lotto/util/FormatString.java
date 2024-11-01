package lotto.util;

public class FormatString {
    private FormatString() {}

    public static String formatPrize(int prize) {
        return String.format("%,d", prize);
    }
}
