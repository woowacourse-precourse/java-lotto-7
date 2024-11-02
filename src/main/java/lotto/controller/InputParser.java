package lotto.controller;

import static lotto.exception.InputParserExceptionMessage.AT_LEAST_ONE_NUMBER;
import static lotto.exception.InputParserExceptionMessage.NUMBER_ONLY;

import java.util.Arrays;
import java.util.List;
import lotto.exception.ExceptionUtils;

public class InputParser {

    public static List<Integer> parseIntegers(String input) {
        validate(input);
        List<Integer> numbers = Arrays.stream(input.split(","))
                .map(String::strip)
                .map(InputParser::parseSingleInteger)
                .toList();
        if (numbers.isEmpty()) {
            throw ExceptionUtils.IllegalArgument(AT_LEAST_ONE_NUMBER);
        }
        return numbers;
    }

    public static int parseInteger(String input) {
        validate(input);
        return parseSingleInteger(input);
    }

    private static void validate(String input) {
        if (input == null || input.isBlank()) {
            throw ExceptionUtils.IllegalArgument(AT_LEAST_ONE_NUMBER);
        }
    }

    private static int parseSingleInteger(String input) {
        try {
            return Integer.parseInt(input.strip());
        } catch (NumberFormatException error) {
            throw ExceptionUtils.IllegalArgumentWithCause(NUMBER_ONLY, error);
        }
    }

}
