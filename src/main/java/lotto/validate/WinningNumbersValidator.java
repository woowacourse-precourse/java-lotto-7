package lotto.validate;

import static lotto.constants.LottoConstants.INPUT_PATTERN;

import lotto.constants.ErrorMessage;

public class WinningNumbersValidator {

    public static void validateWinningNumbers(String input) {
        if (!input.matches(INPUT_PATTERN)) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_PATTERN.getMessage());
        }
    }
}
