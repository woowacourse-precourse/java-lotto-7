package lotto.utils;

public class TextUtils {
    private static final String NUMBER_PATTERN = "-?\\d+(\\.\\d+)?";

    public static boolean isNullOrEmpty(String text) {
        return text == null || text.isEmpty();
    }

    public static boolean isNumber(String text) {
        return text.matches(NUMBER_PATTERN);
    }
}
