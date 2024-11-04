package lotto.utils;

public class PriceFormatter {
    public static String formatToKoreanStyle(int price) {
        return String.format("%,d", price);
    }

    public static String formatToKoreanStyle(float price) {
        return String.format("%,.1f", price);
    }
}
