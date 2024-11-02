package lotto.view;

import static lotto.MessageContainer.NEITHER_DIGIT_NOR_DELIMITER_ERROR;
import static lotto.view.ViewConstants.DIGIT_AND_DELIMITER_ONLY_PATTERN;

import java.util.regex.Matcher;

public class InputValidator {
    public void validateDigitAndDelimiterOnly(String input) {
        Matcher matcher = DIGIT_AND_DELIMITER_ONLY_PATTERN.matcher(input);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(NEITHER_DIGIT_NOR_DELIMITER_ERROR);
        }
    }
}
