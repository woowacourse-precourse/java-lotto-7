package lotto.validator;

import lotto.exception.WinningNumbers.BlankWinningNumbersException;
import lotto.exception.WinningNumbers.InvalidRuleException;

public class WinningNumbersValidator {

    private static final String REGEX_INPUT_RULE = ".*[^,\\d\\s].*";

    public static void validate(final String input) {
        validateBlank(input);
        validateDelimiter(input);
    }

    private static void validateBlank(final String input) {
        if(input.isBlank()) {
            throw new BlankWinningNumbersException();
        }
    }

    private static void validateDelimiter(final String input) {
        if(input.matches(REGEX_INPUT_RULE)) {
            throw new InvalidRuleException();
        }
    }
}
