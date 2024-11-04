package lotto.util.parser;

import static lotto.message.ErrorMessage.INVALID_INTEGER_RANGE_WINNING_NUMBERS_ERROR_MESSAGE;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumberParser {

    private static final String REGEX = ",";

    public static List<Integer> parseRawWinningNumbers(String rawWinningNumber) {
        try {
            String[] contents = rawWinningNumber.split(REGEX);

            return Arrays.stream(contents)
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_INTEGER_RANGE_WINNING_NUMBERS_ERROR_MESSAGE.getContent());
        }
    }
}
