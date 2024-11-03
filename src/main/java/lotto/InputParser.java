package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputParser {
    private static final String WINNING_NUMBER_DELIMITER = ",";
    private static final String INVALID_INPUT_ERROR_MESSAGE = "[ERROR] 정수를 입력해주세요.\n";

    public static List<Integer> parseWinningNumber(final String input) {
        String[] winningNumbers = input.split(WINNING_NUMBER_DELIMITER);

        return Arrays.stream(winningNumbers)
                .map(InputParser::parseInt)
                .collect(Collectors.toList());
    }

    public static int parseInt(final String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println(INVALID_INPUT_ERROR_MESSAGE);
            throw new IllegalArgumentException(INVALID_INPUT_ERROR_MESSAGE);
        }
    }
}
