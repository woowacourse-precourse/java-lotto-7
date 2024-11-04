package lotto.util;

import java.util.Arrays;
import java.util.List;
import lotto.exception.InputErrorMessage;

public class InputParser {
    private static final String INTEGER_REGEX = "^-?[0-9]+$";
    private static final String DELIMITER = ",";

    private InputParser() {
    }

    public static int parseBudget(String input) {
        validateBudget(input);
        return Integer.parseInt(input.trim());
    }

    public static List<Integer> parseWinningNumbers(String input) {
        validateWinningNumbers(input);
        return Arrays.stream(input.split(DELIMITER))
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();
    }

    public static int parseBonusNumber(String input) {
        validateBonusNumber(input);
        return Integer.parseInt(input.trim());
    }

    private static void validateBudget(String lottoPrice) {
        validateInputNullOrEmpty(lottoPrice);
        validateInputIsNumber(lottoPrice.trim());
    }

    private static void validateWinningNumbers(String winningNumbers) {
        validateInputNullOrEmpty(winningNumbers);
        Arrays.stream(winningNumbers.split(DELIMITER))
                .map(String::trim)
                .forEach(InputParser::validateInputIsNumber);
    }

    private static void validateBonusNumber(String bonusNumber) {
        validateInputNullOrEmpty(bonusNumber);
        validateInputIsNumber(bonusNumber.trim());
    }

    private static void validateInputNullOrEmpty(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(InputErrorMessage.INPUT_IS_EMPTY.getMessage());
        }
    }

    private static void validateInputIsNumber(String input) {
        if (input.matches(INTEGER_REGEX)) {
            return;
        }
        throw new NumberFormatException(InputErrorMessage.INPUT_IS_NOT_NUMBER.getMessage());
    }
}
