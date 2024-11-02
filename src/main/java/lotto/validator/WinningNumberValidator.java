package lotto.validator;

import lotto.constant.WinningNumberRule;

import java.util.List;

public class WinningNumberValidator {

    public static void validateInputComma(String input) throws IllegalArgumentException {
        validateDoubletComma(input);
        validateFirstComma(input);
        validateLastComma(input);
    }

    public static void validateInputNumber(List<String> input)throws IllegalArgumentException{
        for (String separatedInput : input){
            validateOnlyInteger(separatedInput);
        };
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

    private static void validateOnlyInteger(String input){
        if(!input.matches(WinningNumberRule.MATCH_NUMBER.getMessage())){
            throw new IllegalArgumentException(WinningNumberRule.ONLY_COMMA_INTEGER.getMessage());
        }
    }
}
