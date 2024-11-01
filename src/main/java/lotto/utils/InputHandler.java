package lotto.utils;

import java.util.List;
import java.util.stream.Stream;
import lotto.constants.ErrorMessage;

public class InputHandler {

    private static final String WINNING_NUMBERS_DELIMITER = ",";

    public static int handleMoneyInput(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_FORMAT_INPUT.getMessage());
        }
    }

    public static List<Integer> handleWinningNumbersInput(String input) {
        try {
            return Stream.of(input.split(WINNING_NUMBERS_DELIMITER))
                    .map(number -> Integer.parseInt(number.trim()))
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.HAS_OUT_OF_RANGE_NUMBER.getMessage());
        }
    }

    public static int handleBonusNumberInput(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_FORMAT_INPUT.getMessage());
        }
    }
}
