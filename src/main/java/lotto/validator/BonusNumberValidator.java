package lotto.validator;

import lotto.common.ErrorMessage;
import lotto.common.RegexPattern;

public class BonusNumberValidator {

    public static int validateBonusNumber(String input){
        validateNullAndBlank(input);
        validatePositiveNumber(input);

        return Integer.parseInt(input);
    }

    private static int validatePositiveNumber(String input){
        if (!RegexPattern.INTEGER_INPUT.matches(input)){
            throw new IllegalArgumentException(ErrorMessage.NOT_INTEGER_INPUT);
        }
        return Integer.parseInt(input);

    }

    private static void validateNullAndBlank(String input) {
            if (input==null || input.isBlank()){
                throw new IllegalArgumentException(ErrorMessage.BLANK_OR_NULL_INPUT);
            }
    }
}
