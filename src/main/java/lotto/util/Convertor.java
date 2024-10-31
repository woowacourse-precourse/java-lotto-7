package lotto.util;

import java.util.Arrays;
import java.util.List;

public class Convertor {

    private static final String NON_NUMERIC_EXCEPTION = "입력값은 숫자여야 합니다";

    public static long convertToLong(String input) {
        try {
            return Long.parseLong(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NON_NUMERIC_EXCEPTION);
        }
    }

    public static int convertToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NON_NUMERIC_EXCEPTION);
        }
    }

    public static List<Integer> convertToIntegerList(String input) {
        return Arrays.stream(input.split(","))
                .map(Convertor::convertToInt)
                .toList();
    }
}
