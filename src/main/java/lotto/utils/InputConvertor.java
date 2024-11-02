package lotto.utils;

import java.util.List;
import java.util.stream.Stream;
import lotto.constants.ErrorMessage;

public class InputConvertor {

    private static final String WINNING_NUMBERS_DELIMITER = ",";

    public static int convertMoneyInput(String moneyInput) {
        try {
            return Integer.parseInt(moneyInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_FORMAT_INPUT.getMessage());
        }
    }

    public static List<Integer> convertWinningNumbersInput(String winningNumbersInput) {
        try {
            return Stream.of(winningNumbersInput.split(WINNING_NUMBERS_DELIMITER))
                    .map(number -> Integer.parseInt(number.trim()))
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.HAS_OUT_OF_RANGE_NUMBER.getMessage());
        }
    }

    public static int convertBonusNumberInput(String bonusNumberInput) {
        try {
            return Integer.parseInt(bonusNumberInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_FORMAT_INPUT.getMessage());
        }
    }
}
