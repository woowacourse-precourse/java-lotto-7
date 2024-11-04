package lotto.view.util;

import java.util.List;
import java.util.regex.Pattern;

import static lotto.exception.ExceptionMessage.INVALID_DELIMITER_FORMAT;
import static lotto.exception.ExceptionMessage.INVALID_WINNING_NUMBER_FORMAT;

public class WinningNumberSplitter {

    public static final String DELIMITER = ",";
    public static final Pattern INVALID_NUMBER_AND_COMMA_REGEX = Pattern.compile(".*[^0-9,].*");

    public List<String> splitWinningNumber(String input) {
        validateWinningNumber(input);
        return List.of(input.split(DELIMITER));
    }

    private void validateWinningNumber(String input) {
        validateDelimiterFormat(input);
        validateEndFormat(input);
    }

    private void validateDelimiterFormat(String input) {
        if (INVALID_NUMBER_AND_COMMA_REGEX.matcher(input).find()) {
            throw new IllegalArgumentException(INVALID_DELIMITER_FORMAT.getMessage());
        }
    }

    private void validateEndFormat(String input) {
        if (input.endsWith(DELIMITER)) {
            throw new IllegalArgumentException(INVALID_WINNING_NUMBER_FORMAT.getMessage());
        }
    }
}
