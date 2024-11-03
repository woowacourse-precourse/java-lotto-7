package lotto;

import static lotto.ErrorMessage.NOT_INTEGER;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputParser {
    private static final String WINNING_NUMBER_DELIMITER = ",";

    public static List<Integer> parseWinningNumbers(final String input) {
        String[] winningNumbers = input.split(WINNING_NUMBER_DELIMITER);

        return Arrays.stream(winningNumbers)
                .map(InputParser::parseInt)
                .collect(Collectors.toList());
    }

    public static int parseInt(final String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_INTEGER.getMessage());
        }
    }
}
