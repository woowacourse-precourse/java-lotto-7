package lotto.util;

import java.util.Arrays;
import java.util.List;

public class InputParser {

    public static String getComma(long number) {
        return String.format("%,d", number);
    }

    public static long parseLong(String input) {
        return Long.parseLong(input);
    }

    public static List<Integer> parseList(String input) {
        return Arrays.stream(input.split(Regex.COMMA.getValue())).map(Integer::parseInt).toList();
    }
}
