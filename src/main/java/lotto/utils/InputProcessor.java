package lotto.utils;

import static lotto.exception.Exception.INVALID_NUMBER;
import static lotto.exception.Exception.MAXIMUM_NUMBER_LENGTH;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputProcessor {

    private static final int MAX_LENGTH = 9;
    private static final String DELIMITER = ",";

    public static Integer parseSingleInteger(String input) {
        validateInt(input);

        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_NUMBER.getMessage());
        }
    }

    public static List<Integer> parseIntegerList(String input) {
        validatePresence(input);
        String[] numbers = parseStringArray(input);

        return Arrays.stream(numbers)
                .map(InputProcessor::parseSingleInteger)
                .collect(Collectors.toList());
    }

    private static void validateInt(String input) {
        validatePresence(input);
        validateLength(input);
    }

    private static void validatePresence(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(INVALID_NUMBER.getMessage());
        }
    }

    public static void validateLength(String input) {
        if (input.trim().length() > MAX_LENGTH) {
            throw new IllegalArgumentException(MAXIMUM_NUMBER_LENGTH.getMessage());
        }
    }

    private static String[] parseStringArray(String input) {
        return input.split(DELIMITER);
    }
}
