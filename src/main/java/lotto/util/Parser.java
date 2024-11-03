package lotto.util;

import static lotto.config.ErrorMessageConstant.NON_NUMERIC_MESSAGE;

import java.util.List;

public class Parser {
    private Parser() {
    }

    public static int parseToInteger(String input) {
        validateNumericInput(input);
        return Integer.parseInt(input);
    }

    public static List<Integer> parseToIntegerList(List<String> input) {
        for (String in : input) {
            validateNumericInput(in);
        }

        return input.stream()
                .map(Integer::parseInt)
                .toList();
    }

    private static void validateNumericInput(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NON_NUMERIC_MESSAGE);
        }
    }
}
