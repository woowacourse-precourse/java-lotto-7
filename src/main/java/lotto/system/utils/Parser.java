package lotto.system.utils;

import java.util.Arrays;
import java.util.List;

public class Parser {

    private static final String DELIMITER_UNIT = ",";

    public static String joinWithDelimiter(List<Integer> input, String delimiter) {
        return input.stream()
                .map(String::valueOf)
                .reduce((a, b) -> a + delimiter + " " + b)
                .orElse("");
    }

    public static List<Integer> parseWithDelimiter(String input, String delimiter) {
        return Arrays.stream(input.split(delimiter))
                .map(Integer::parseInt)
                .toList();
    }

    public static List<Integer> parseWithDelimiter(String input) {
        return parseWithDelimiter(input, DELIMITER_UNIT);
    }
}
