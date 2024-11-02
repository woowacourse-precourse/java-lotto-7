package lotto.validator;

import lotto.constant.WinningNumberRule;

public class WinningNumberValidator {

    public static void validateInputComma(String input) throws IllegalArgumentException {
        validateDoubletComma(input);
        validateFirstComma(input);
        validateLastComma(input);
    }

    private static void validateDoubletComma(String input) throws IllegalArgumentException {
        if (input.contains(WinningNumberRule.COMMA.getMessage() + WinningNumberRule.COMMA.getMessage())) {
            throw new IllegalArgumentException(WinningNumberRule.DOUBLE_COMMA.getMessage());
        }
    }

    private static void validateFirstComma(String input) throws IllegalArgumentException{
        if(input.startsWith(WinningNumberRule.COMMA.getMessage())){
            throw new IllegalArgumentException(WinningNumberRule.COMMA_FIRST.getMessage());
        }
    }

    private static void validateLastComma(String input) throws IllegalArgumentException{
        if(input.endsWith(WinningNumberRule.COMMA.getMessage())){
            throw new IllegalArgumentException(WinningNumberRule.COMMA_LAST.getMessage());
        }
    }
}
