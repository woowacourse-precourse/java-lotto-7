package lotto.input;

import static lotto.exception.ExceptionMessage.*;

import java.util.List;
import java.util.stream.Stream;

public class WinningNumberProcessor {

    private static final String NUMBER_SEPARATOR = ",";

    private WinningNumberProcessor() {
    }

    public static List<Integer> processWinningNumbers(String input) {
        validateInput(input);
        return parseInputToList(input);
    }

    private static void validateInput(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(EMPTY_INPUT.getMessage());
        }
        if (input.trim().startsWith(NUMBER_SEPARATOR) || input.trim().endsWith(NUMBER_SEPARATOR)) {
            throw new IllegalArgumentException(INVALID_COMMA_POSITION.getMessage());
        }
    }

    private static List<Integer> parseInputToList(String input) {
        try {
            return Stream.of(input.split(NUMBER_SEPARATOR))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NON_NUMERIC_INPUT.getMessage(), e);
        }
    }
}
