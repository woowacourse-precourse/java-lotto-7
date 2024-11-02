package lotto.validator;

import lotto.constant.WinningNumberRule;

public class WinningNumberValidator {

    public void validateInputComma(String input) throws IllegalArgumentException {
        validateDoubletComma(input);
        validateFirstComma(input);
        validateLastComma(input);
    }

    private void validateDoubletComma(String input) throws IllegalArgumentException {
        if (input.contains(WinningNumberRule.COMMA.getMessage() + WinningNumberRule.COMMA.getMessage())) {
            throw new IllegalArgumentException(WinningNumberRule.DOUBLE_COMMA.getMessage());
        }
    }

    private void validateFirstComma(String input) throws IllegalArgumentException{
        if(input.startsWith(WinningNumberRule.COMMA.getMessage())){
            throw new IllegalArgumentException(WinningNumberRule.COMMA_FIRST.getMessage());
        }
    }

    private void validateLastComma(String input) throws IllegalArgumentException{
        if(input.endsWith(WinningNumberRule.COMMA.getMessage())){
            throw new IllegalArgumentException(WinningNumberRule.COMMA_LAST.getMessage());
        }
    }
}
