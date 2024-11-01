package lotto.utils;

import java.util.List;
import java.util.stream.Stream;

public class InputHandler {

    private static final String WINNING_NUMBERS_DELIMITER = ",";

    public static int handleMoneyInput(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public static List<Integer> handleWinningNumbersInput(String input) {
        try {
            return Stream.of(input.split(WINNING_NUMBERS_DELIMITER))
                    .map(number -> Integer.parseInt(number.trim()))
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public static int handleBonusNumberInput(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
