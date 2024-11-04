package lotto;

import static lotto.ErrorMessage.NOT_INTEGER;

import java.util.Arrays;
import java.util.List;

public class InputParser {
    private static final String WINNING_NUMBER_DELIMITER = ",";

    public static int parsePurchaseAmount(final String input) {
        return parseInt(input);
    }

    public static List<Integer> parseWinningNumbers(final String input) {
        String[] winningNumbers = input.split(WINNING_NUMBER_DELIMITER);
        return Arrays.stream(winningNumbers)
                .map(InputParser::parseInt)
                .toList();
    }

    public static int parseBonusNumber(final String input) {
        return parseInt(input);
    }

    private static int parseInt(final String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_INTEGER.getMessage());
        }
    }
}
