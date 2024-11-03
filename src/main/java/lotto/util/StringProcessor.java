package lotto.util;

import static lotto.constant.ErrorMessage.EMPTY_INPUT_ERROR;
import static lotto.constant.ErrorMessage.NULL_INPUT_ERROR;
import static lotto.constant.ErrorMessage.NUMBER_RANGE_ERROR;

import java.util.ArrayList;
import java.util.List;

public class StringProcessor {
    private static final String COMMA = ",";
    private static final String EMPTY = "";
    private static final int MIN_POSITIVE_NUMBER = 1;

    public static void validateInput(String input) {
        if (input == null) {
            throw new IllegalArgumentException(NULL_INPUT_ERROR.getMessage());
        }

        if (input.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_INPUT_ERROR.getMessage());
        }
    }

    public static String removeCommas(String input) {
        return input.replaceAll(COMMA, EMPTY);
    }

    public static int integerConverter(String input) {
        try {
            int number = Integer.parseInt(input.trim());

            if (number < MIN_POSITIVE_NUMBER) {
                throw new IllegalArgumentException(NUMBER_RANGE_ERROR.getMessage());
            }

            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_RANGE_ERROR.getMessage());
        }
    }

    public static String[] splitInputString(String input) {
        return input.split(COMMA);
    }

    public static List<Integer> integerListConverter(String[] strings) {
        List<Integer> numbers = new ArrayList<>();
        for (String element : strings) {
            int number = integerConverter(element);
            numbers.add(number);
        }

        return numbers;
    }
}
