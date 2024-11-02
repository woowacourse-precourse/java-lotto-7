package lotto.util;

import java.util.Arrays;
import java.util.List;

public class InputParser {

    public static long parseLong(String input) {
        return Long.parseLong(input);
    }

    public static List<Integer> parseListOfInteger(String input) {
        return Arrays.stream(input.split(Regex.COMMA.getValue())).map(Integer::parseInt).toList();
    }

    public static int parseInt(String input) {
        return Integer.parseInt(input);
    }
}
