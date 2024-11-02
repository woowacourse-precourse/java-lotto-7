package lotto.validator;

import lotto.constant.WinningNumberRule;

public class WinningNumberValidator {

    public void validateInputComma(String input) throws IllegalArgumentException {
        validateDoubletComma(input);

    }

    private void validateDoubletComma(String input) throws IllegalArgumentException {
        if (input.contains(WinningNumberRule.COMMA.getMessage() + WinningNumberRule.COMMA.getMessage())) {
            throw new IllegalArgumentException(WinningNumberRule.DOUBLE_COMMA.getMessage());
        }
    }
}
