package lotto.utils;

public class PriceFormatter {
    public static String formatToKoreanStyle(int price) {
        return String.format("%,d", price);
    }
}
