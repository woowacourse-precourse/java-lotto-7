package lotto.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Converter {
    public static final String DELIMITER = ",";
    private static final String WHITESPACE_REGEX = "\\s+";
    private static final String EMPTY_STRING = "";

    private Converter() {
    }

    public static int convertToNumber(final String input) {
        return Integer.parseInt(input.trim());
    }

    public static List<Integer> convertNumbers(String input) {
        return Arrays.stream(input.split(DELIMITER))
                .map(String::trim)
                .map(Converter::convertToNumber)
                .collect(Collectors.toList());
    }

    public static String trimInput(String input) {
        return input.replaceAll(WHITESPACE_REGEX, EMPTY_STRING);
    }
}
