package lotto.utils;

import java.util.List;
import java.util.stream.Stream;
import lotto.constants.ExceptionMessage;

public class InputHandler {

    private static final String WINNING_NUMBERS_DELIMITER = ",";

    public static int toMoneyValue(String input) {
        validate(input);
        return Integer.parseInt(input);
    }

    public static List<Integer> toWinningNumbersValue(String input) {
        String[] numbers = input.split(WINNING_NUMBERS_DELIMITER);
        Stream.of(numbers).forEach(number -> validate(number.trim()));
        return Stream.of(numbers).map(number -> Integer.parseInt(number.trim())).toList();
    }

    public static int toBonusNumberValue(String input) {
        validate(input);
        return Integer.parseInt(input);
    }

    private static void validate(String input) {
        if (!isNumeric(input)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_FORMAT_INPUT.getMessage());
        }
    }

    private static boolean isNumeric(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
