package lotto.utils;

import static lotto.constans.ErrorMessages.ERROR_NON_NUMERIC_INPUT;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputParser {

    private static final String DELIMITER = ",";

    public static List<String> parseCommaSeparatedStrings(String input) {
        return Arrays.stream(input.split(DELIMITER))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public static List<Integer> convertStringsToIntegers(List<String> strings) {
        try {
            return strings.stream()
                    .map(InputParser::stringToInteger)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_NON_NUMERIC_INPUT);
        }
    }

    public static int stringToInteger(String input) {
        return Integer.parseInt(input);
    }
}
