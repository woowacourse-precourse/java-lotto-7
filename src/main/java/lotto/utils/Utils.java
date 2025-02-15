package lotto.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {
    private static final Pattern INPUT_PATTERN = Pattern.compile("^[0-9]{1,2}(,[0-9]{1,2})*$");

    public static void validateInputWinningNumbers(String input) {
        Matcher matcher = INPUT_PATTERN.matcher(input);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_INPUT_WINNING_NUMBER.getMessage());
        }
    }

    public static int parseNumber(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_PARSE_NUMBER.getMessage());
        }
    }


}
