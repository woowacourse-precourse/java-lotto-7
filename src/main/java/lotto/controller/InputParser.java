package lotto.controller;

import static lotto.exception.InputParserExceptionMessage.AT_LEAST_ONE_NUMBER;
import static lotto.exception.InputParserExceptionMessage.NUMBER_ONLY;

import java.util.Arrays;
import java.util.List;
import lotto.exception.ExceptionUtils;

public class InputParser {

    public static List<Integer> parseIntegers(String input) {
        String[] split = input.split(",");

        List<Integer> integers = null;
        try {
            integers = Arrays.stream(split).map(String::strip).map(Integer::parseInt).toList();
        } catch (NumberFormatException error) {
            throw ExceptionUtils.IllegalArgumentWithCause(NUMBER_ONLY, error);
        }

        if (integers.isEmpty()) {
            throw ExceptionUtils.IllegalArgument(AT_LEAST_ONE_NUMBER);
        }

        return integers;
    }

    public static int parseInteger(String input) {
        int integer;

        try {
            integer = Integer.parseInt(input);
        } catch (NumberFormatException error) {
            throw ExceptionUtils.IllegalArgumentWithCause(NUMBER_ONLY, error);
        }

        return integer;
    }

}
